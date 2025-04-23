package com.example.eqmmatriculaservice.dto;

public class CursoDTO {

    private Integer id;
    private String codigo;
    private String nombre;
    private Integer capacidad;
    private String ciclo;
    private String horario;

    public CursoDTO() {
    }

    public CursoDTO(Integer id, String codigo, String nombre, Integer capacidad, String ciclo, String horario) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ciclo = ciclo;
        this.horario = horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
