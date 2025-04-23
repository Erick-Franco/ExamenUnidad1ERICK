package com.example.eqmestudianteservice.controller;

import com.example.eqmestudianteservice.entity.Estudiante;
import com.example.eqmestudianteservice.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        try {
            Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
            return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Obtener todos los estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes() {
        try {
            List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
            if (estudiantes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable("id") Integer id) {
        try {
            Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
            if (estudiante != null) {
                return new ResponseEntity<>(estudiante, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar estudiante
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable("id") Integer id, @RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, estudiante);
            if (estudianteActualizado != null) {
                return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Eliminar estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarEstudiante(@PathVariable("id") Integer id) {
        try {
            boolean eliminado = estudianteService.eliminarEstudiante(id);
            if (eliminado) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
