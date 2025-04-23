package com.example.eqmmatriculaservice.service.impl;


import com.example.eqmcursoservice.entity.Curso;
import com.example.eqmcursoservice.repository.CursoRepository;
import com.example.eqmestudianteservice.entity.Estudiante;
import com.example.eqmestudianteservice.repository.EstudianteRepository;
import com.example.eqmmatriculaservice.entity.Matricula;
import com.example.eqmmatriculaservice.repository.MatriculaRepository;
import com.example.eqmmatriculaservice.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // Crear una nueva matrícula
    @Override
    public Matricula crearMatricula(Matricula matricula) throws Exception {
        // Validación de que el estudiante exista y esté activo
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(matricula.getEstudiante().getId());
        if (!estudianteOptional.isPresent()) {
            throw new Exception("Estudiante no encontrado");
        }
        Estudiante estudiante = estudianteOptional.get();

        // Verificar si el estado del estudiante es "ACTIVO"
        if (estudiante.getEstado() == null || !estudiante.getEstado().equals("ACTIVO")) {
            throw new Exception("El estudiante no está activo");
        }

        // Validación de que el curso exista y tenga capacidad disponible
        Optional<Curso> cursoOptional = cursoRepository.findById(matricula.getCurso().getId());
        if (!cursoOptional.isPresent()) {
            throw new Exception("Curso no encontrado");
        }
        Curso curso = cursoOptional.get();

        // Verificar si el curso tiene capacidad disponible
        if (curso.getCapacidad() == null || curso.getCapacidad() <= 0) {
            throw new Exception("El curso no tiene capacidad disponible");
        }

        // Crear la matrícula
        return matriculaRepository.save(matricula);
    }

    // Obtener todas las matrículas
    @Override
    public List<Matricula> obtenerTodasLasMatriculas() {
        return matriculaRepository.findAll();
    }

    // Obtener matrícula por ID
    @Override
    public Matricula obtenerMatriculaPorId(Integer id) {
        Optional<Matricula> matriculaOptional = matriculaRepository.findById(id);
        return matriculaOptional.orElse(null); // Retorna null si no se encuentra la matrícula
    }

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
}
