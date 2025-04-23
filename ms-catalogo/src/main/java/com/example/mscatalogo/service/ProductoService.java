package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Producto save(Producto producto);
    Producto update(Producto producto);
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    void delete(Long id);

}
