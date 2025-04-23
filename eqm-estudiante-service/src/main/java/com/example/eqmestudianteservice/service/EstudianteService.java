package com.example.eqmestudianteservice.service;


import com.example.eqmestudianteservice.entity.Estudiante;

import java.util.List;

public interface EstudianteService {

    Estudiante crearEstudiante(Estudiante estudiante) throws Exception;

    List<Estudiante> obtenerTodosLosEstudiantes();

    Estudiante obtenerEstudiantePorId(Integer id); // Cambiado a Integer

    Estudiante actualizarEstudiante(Integer id, Estudiante estudiante); // Cambiado a Integer

    boolean eliminarEstudiante(Integer id); // Solo deja esta versión
}
