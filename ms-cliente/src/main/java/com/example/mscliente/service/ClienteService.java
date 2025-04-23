package com.example.mscliente.service;

import com.example.mscliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    Optional <Cliente> findById(Long id);
    List<Cliente> findAll();
    void delete(Long id);

}
