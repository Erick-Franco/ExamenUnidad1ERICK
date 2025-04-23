package com.example.mspedido.service.sericeImpl;

import com.example.mspedido.dto.Cliente;
import com.example.mspedido.dto.Producto;
import com.example.mspedido.entity.Pedido;
import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.feign.ClienteFeign;
import com.example.mspedido.feign.ProductoFeign;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteFeign clienteFeign;

    @Autowired
    private ProductoFeign productoFeign;


    @Override
    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> getPedidoById(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        Cliente cliente = clienteFeign.listarcliente(pedido.getClienteId()).getBody();
        pedido.setCliente(cliente);
        List<PedidoDetalle> pedidoDetalles = pedido.getDetalle().stream().map(pedidoDetalle -> {
            Producto producto = productoFeign.listarProducto(pedidoDetalle.getProductoId()).getBody();
            pedidoDetalle.setProducto(producto);
            pedidoDetalle.setProducto(producto);
            return pedidoDetalle;
        }).collect(Collectors.toList());
        pedido.setDetalle(pedidoDetalles);
        pedido.setCliente(cliente);
        return Optional.of(pedido);
    }

    @Override
    public Pedido updatePedido(Integer id, Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
