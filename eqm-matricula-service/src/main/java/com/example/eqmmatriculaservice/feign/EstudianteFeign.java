package com.example.eqmmatriculaservice.feign;


import com.example.eqmestudianteservice.entity.Estudiante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mjm-estudiante-service", path = "/estudiantes")
public interface EstudianteFeign {

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> listById(@PathVariable(required = true) Integer id);
}