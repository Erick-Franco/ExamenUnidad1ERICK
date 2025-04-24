package com.example.eqmmatriculaservice.feign;

import com.example.eqmcursoservice.entity.Curso;
import com.example.eqmmatriculaservice.dto.CursoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "curso-service", url = "http://localhost:8081")
public interface CursoFeign {
    @GetMapping("/cursos/{id}")
    ResponseEntity<CursoDTO> obtenerCursoPorId(@PathVariable("id") Integer id);
}



