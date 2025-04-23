package com.example.eqmmatriculaservice.feign;

import com.example.eqmcursoservice.entity.Curso;
import com.example.eqmmatriculaservice.dto.CursoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "eqm-curso-service", path = "/cursos")
public interface CursoFeign {

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable("id") Integer id);
}
