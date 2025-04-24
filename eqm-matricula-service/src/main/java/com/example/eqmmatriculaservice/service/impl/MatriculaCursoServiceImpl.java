package com.example.eqmmatriculaservice.service.impl;

import com.example.eqmmatriculaservice.dto.CursoDTO;
import com.example.eqmmatriculaservice.dto.EstudianteDTO;
import com.example.eqmmatriculaservice.entity.Matricula;

import com.example.eqmmatriculaservice.feign.CursoFeign;
import com.example.eqmmatriculaservice.feign.EstudianteFeign;
import com.example.eqmmatriculaservice.repository.MatriculaRepository;
import com.example.eqmmatriculaservice.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaCursoServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private CursoFeign cursoFeignClient;

    @Autowired
    private EstudianteFeign estudianteFeignClient;

    @Override
    public Matricula crearMatricula(Matricula matricula) throws Exception {
        EstudianteDTO estudiante = estudianteFeignClient.obtenerEstudiantePorId(matricula.getEstudianteId()).getBody();
        if (estudiante == null) throw new Exception("Estudiante no encontrado");
        if (!"ACTIVO".equals(estudiante.getEstado())) throw new Exception("El estudiante no está activo");

        CursoDTO curso = cursoFeignClient.obtenerCursoPorId(matricula.getCursoCodigo()).getBody();
        if (curso == null) throw new Exception("Curso no encontrado");
        if (curso.getCapacidad() == null || curso.getCapacidad() <= 0) throw new Exception("El curso no tiene capacidad disponible");

        return matriculaRepository.save(matricula);
    }

    @Override
    public List<Matricula> obtenerTodasLasMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> obtenerMatriculaPorId(Integer id) {
        Matricula matricula = matriculaRepository.findById(id).orElse(null);
        if (matricula == null) return Optional.empty();

        CursoDTO curso = cursoFeignClient.obtenerCursoPorId(matricula.getCursoCodigo()).getBody();
        EstudianteDTO estudiante = estudianteFeignClient.obtenerEstudiantePorId(matricula.getEstudianteId()).getBody();

        matricula.setCurso(curso);
        matricula.setEstudiante(estudiante);

        return Optional.of(matricula);
    }

    @Override
    public Matricula actualizarMatricula(Integer id, Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public boolean eliminarMatricula(Integer id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
