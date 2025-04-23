package com.example.mspedido.service;

import com.example.mspedido.entity.PedidoDetalle;

import java.util.List;
import java.util.Optional;

public interface PedidoDetalleService {
    PedidoDetalle createPedidoDetalle(PedidoDetalle pedidoDetalle);

    List<PedidoDetalle> getAllPedidoDetalles();

    Optional<PedidoDetalle> getPedidoDetalleById(Integer id);

    PedidoDetalle updatePedidoDetalle(Integer id, PedidoDetalle pedidoDetalle);

    void deletePedidoDetalle(Integer id);
}
