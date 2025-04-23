package com.example.mspedido.controller;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevo = pedidoService.createPedido(pedido);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable Integer id) {
        return pedidoService.getPedidoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Pedido actualizado = pedidoService.updatePedido(id, pedido);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Integer id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}
