package com.example.eqmmatriculaservice.feign;


import com.example.eqmestudianteservice.entity.Estudiante;
import com.example.eqmmatriculaservice.dto.EstudianteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "estudiante-service")
public interface EstudianteFeign {

    @GetMapping("/estudiantes/{id}")
    ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable("id") Integer id);
}
