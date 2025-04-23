package com.example.mspedido.service.sericeImpl;

import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.repository.PedidoDetalleRepository;
import com.example.mspedido.service.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoDetalleServiceImpl implements PedidoDetalleService {

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Override
    public PedidoDetalle createPedidoDetalle(PedidoDetalle pedidoDetalle) {
        return pedidoDetalleRepository.save(pedidoDetalle);
    }

    @Override
    public List<PedidoDetalle> getAllPedidoDetalles() {
        return pedidoDetalleRepository.findAll();
    }

    @Override
    public Optional<PedidoDetalle> getPedidoDetalleById(Integer id) {
        return pedidoDetalleRepository.findById(id);
    }

    @Override
    public PedidoDetalle updatePedidoDetalle(Integer id, PedidoDetalle pedidoDetalle) {
        return pedidoDetalleRepository.save(pedidoDetalle);
    }

    @Override
    public void deletePedidoDetalle(Integer id) {
        pedidoDetalleRepository.deleteById(id);
    }
}
