package com.example.mspedido.entity;

import com.example.mspedido.dto.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serie;
    private String numero;
    private String descripcion;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Transient
    private Cliente cliente;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<PedidoDetalle> detalle;

    public Pedido() {
    }

    public Pedido(Integer id, String serie, String numero, String descripcion, Long clienteId, Cliente cliente, List<PedidoDetalle> detalle) {
        this.id = id;
        this.serie = serie;
        this.numero = numero;
        this.descripcion = descripcion;
        this.clienteId = clienteId;
        this.cliente = cliente;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<PedidoDetalle> detalle) {
        this.detalle = detalle;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
