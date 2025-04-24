package com.example.eqmmatriculaservice.service.impl;





import com.example.eqmcursoservice.entity.Curso;
import com.example.eqmestudianteservice.entity.Estudiante;
import com.example.eqmmatriculaservice.dto.CursoDTO;
import com.example.eqmmatriculaservice.dto.EstudianteDTO;
import com.example.eqmmatriculaservice.entity.Matricula;
import com.example.eqmmatriculaservice.feign.CursoFeign;
import com.example.eqmmatriculaservice.feign.EstudianteFeign;
import com.example.eqmmatriculaservice.repository.MatriculaRepository;
import com.example.eqmmatriculaservice.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private EstudianteFeign estudianteFeignClient;

    @Autowired
    private CursoFeign cursoFeignClient;


    // Crear una nueva matrícula
    @Override
    public Matricula crearMatricula(Matricula matricula) throws Exception {
        // Obtener estudiante usando Feign Client
        EstudianteDTO estudiante = estudianteFeignClient.obtenerEstudiantePorId(matricula.getEstudianteId()).getBody();
        if (estudiante == null) {
            throw new Exception("Estudiante no encontrado");
        }

        // Verificar si el estudiante está activo
        if (!"ACTIVO".equals(estudiante.getEstado())) {
            throw new Exception("El estudiante no está activo");
        }

        // Obtener curso usando Feign Client
        CursoDTO curso = cursoFeignClient.obtenerCursoPorId(matricula.getCursoCodigo()).getBody();
        if (curso == null) {
            throw new Exception("Curso no encontrado");
        }

        // Verificar la capacidad del curso
        if (curso.getCapacidad() == null || curso.getCapacidad() <= 0) {
            throw new Exception("El curso no tiene capacidad disponible");
        }

        // Crear y guardar la matrícula
        return matriculaRepository.save(matricula);
    }


    // Obtener todas las matrículas
    @Override
    public List<Matricula> obtenerTodasLasMatriculas() {
        return matriculaRepository.findAll();
    }

    // Obtener matrícula por ID
    /*@Override
    public Matricula obtenerMatriculaPorId(Integer id) {
        Optional<Matricula> matriculaOptional = matriculaRepository.findById(id);
        return matriculaOptional.orElse(null); // Retorna null si no se encuentra la matrícula
    }*/

    // Actualizar matrícula
    @Override
    public Matricula actualizarMatricula(Integer id, Matricula matricula) {
        if (matriculaRepository.existsById(id)) {
            matricula.setId(id);  // Establece el ID de la matrícula antes de actualizar
            return matriculaRepository.save(matricula);
        }
        return null; // Retorna null si no se encuentra la matrícula
    }

    // Eliminar matrícula
    @Override
    public boolean eliminarMatricula(Integer id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return true;
        }
        return false; // Retorna false si no se encuentra la matrícula
    }

    @Override
    public Optional<Matricula> obtenerMatriculaPorId(Integer id) {
        Matricula matricula = matriculaRepository.findById(id).orElse(null);
        if (matricula == null) return Optional.empty();

        try {
            ResponseEntity<CursoDTO> cursoResponse = cursoFeignClient.obtenerCursoPorId(matricula.getCursoCodigo());
            ResponseEntity<EstudianteDTO> estudianteResponse = estudianteFeignClient.obtenerEstudiantePorId(matricula.getEstudianteId());

            if (cursoResponse.getBody() == null) throw new Exception("Curso no encontrado");
            if (estudianteResponse.getBody() == null) throw new Exception("Estudiante no encontrado");

            matricula.setCurso(cursoResponse.getBody());
            matricula.setEstudiante(estudianteResponse.getBody());

            System.out.println("Estudiante ID: " + matricula.getEstudianteId());
            System.out.println("Curso Código: " + matricula.getCursoCodigo());
            System.out.println("Estudiante: " + estudianteResponse.getBody());
            System.out.println("Curso: " + cursoResponse.getBody());


        } catch (Exception e) {
            throw new RuntimeException("Error al obtener datos relacionados: " + e.getMessage());



        }


        return Optional.of(matricula);

    }

}
