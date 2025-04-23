package com.example.eqmmatriculaservice.feign;

import com.example.eqmcursoservice.entity.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "mjm-curso-service", path = "/cursos")
public interface CursoFeign {

    @GetMapping("/{id}")
    public ResponseEntity<Curso> listById(@PathVariable(required = true) Integer id);
}