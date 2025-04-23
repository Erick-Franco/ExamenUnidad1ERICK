package com.example.eqmestudianteservice.service.impl;



import com.example.eqmestudianteservice.entity.Estudiante;
import com.example.eqmestudianteservice.repository.EstudianteRepository;
import com.example.eqmestudianteservice.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;


    // Crear un nuevo estudiante
    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) throws Exception {
        // Validación: el documento no puede ser nulo o vacío
        if (estudiante.getDocumento() == null || estudiante.getDocumento().isEmpty()) {
            throw new Exception("El documento del estudiante es obligatorio");
        }

        // Validación: el documento debe ser único
        if (estudianteRepository.existsByDocumento(estudiante.getDocumento())) {
            throw new Exception("El documento ya está registrado");
        }

        // Guardar el estudiante si pasa las validaciones
        return estudianteRepository.save(estudiante);
    }


    // Obtener todos los estudiantes
    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }



    // Obtener estudiante por ID
    @Override
    public Estudiante obtenerEstudiantePorId(Integer id) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
        return estudianteOptional.orElse(null); // Retorna null si no se encuentra el estudiante
    }

    // Actualizar un estudiante existente
    @Override
    public Estudiante actualizarEstudiante(Integer id, Estudiante estudiante) {
        // Verifica si el estudiante existe
        if (estudianteRepository.existsById(id)) {
            estudiante.setId(id);
            return estudianteRepository.save(estudiante); // Actualiza el estudiante
        }
        return null; // Retorna null si el estudiante no existe
    }

    // Eliminar un estudiante
    @Override
    public boolean eliminarEstudiante(Integer id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id); // Elimina el estudiante
            return true;
        }
        return false; // Retorna false si no se encuentra el estudiante
    }
}
