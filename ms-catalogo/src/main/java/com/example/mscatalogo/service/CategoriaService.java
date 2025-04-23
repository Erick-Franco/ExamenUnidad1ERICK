package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    Categoria update(Categoria categoria);
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    void delete(Long id);

}
