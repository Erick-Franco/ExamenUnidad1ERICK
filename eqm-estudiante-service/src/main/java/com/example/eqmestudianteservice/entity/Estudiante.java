package com.example.eqmestudianteservice.entity;


import jakarta.persistence.*;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String carrera;

    private String documento;

    private String estado;

    private Integer cicloActual;

    // Getters y Setters


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

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", documento='" + documento + '\'' +
                ", estado='" + estado + '\'' +
                ", cicloActual=" + cicloActual +
                '}';
    }
}
