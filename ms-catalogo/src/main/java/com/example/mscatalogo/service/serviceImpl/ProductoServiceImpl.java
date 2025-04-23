package com.example.mscatalogo.service.serviceImpl;


import com.example.mscatalogo.entity.Producto;
import com.example.mscatalogo.exepciones.ResourceNotFoundException;
import com.example.mscatalogo.repository.ProductoRepository;
import com.example.mscatalogo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        Producto productoExistente = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("producto no encontrada"));
        if (producto.getNombre() != null) {
            productoExistente.setCodigo(producto.getCodigo());
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setCategoria(producto.getCategoria());
            productoExistente.setCantidad(producto.getCantidad());
            productoExistente.setPrecioCompra(producto.getPrecioCompra());
            productoExistente.setPrecioVenta(producto.getPrecioVenta());
        }
        return productoRepository.save(productoExistente);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
