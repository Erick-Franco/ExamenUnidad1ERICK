package com.example.eqmmatriculaservice.entity;

import jakarta.persistence.*;

@Entity
public class MatriculaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "curso_id")
    private Long cursoId;

    public MatriculaCurso() {
    }

    public MatriculaCurso(Integer id, Long cursoId) {
        this.id = id;
        this.cursoId = cursoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}