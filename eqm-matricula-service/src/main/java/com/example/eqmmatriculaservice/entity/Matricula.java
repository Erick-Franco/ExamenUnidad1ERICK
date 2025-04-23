package com.example.eqmmatriculaservice.entity;


import com.example.eqmcursoservice.entity.Curso;
import com.example.eqmestudianteservice.entity.Estudiante;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_codigo", nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private LocalDate fechaMatricula;

    @Column(nullable = false)
    private String ciclo;

    public Matricula() {
    }

    public Matricula(Integer id, Estudiante estudiante, Curso curso, LocalDate fechaMatricula, String ciclo) {
        this.id = id;
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaMatricula = fechaMatricula;
        this.ciclo = ciclo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
}
