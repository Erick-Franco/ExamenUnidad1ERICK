package com.example.eqmmatriculaservice.dto;

public class EstudianteDTO {

    private Integer id;
    private String nombre;
    private String carrera;
    private String documento;
    private String estado;
    private Integer cicloActual;

    public EstudianteDTO() {
    }

    public EstudianteDTO(Integer id, String nombre, String carrera, String documento, String estado, Integer cicloActual) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.documento = documento;
        this.estado = estado;
        this.cicloActual = cicloActual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(Integer cicloActual) {
        this.cicloActual = cicloActual;
    }
}
