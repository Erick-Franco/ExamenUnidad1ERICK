package com.example.mscliente.service.serviceImpl;

import com.example.mscliente.entity.Cliente;
import com.example.mscliente.exepciones.ResourceNotFoundException;
import com.example.mscliente.repository.ClienteRepository;
import com.example.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        Cliente clieteexistente = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));
        if (cliente.getNombre() != null) {
            clieteexistente.setDni(cliente.getDni());
            clieteexistente.setNombre(cliente.getNombre());
            clieteexistente.setApellido(cliente.getApellido());
            clieteexistente.setTelefono(cliente.getTelefono());
            clieteexistente.setEmail(cliente.getEmail());
            clieteexistente.setDireccion(cliente.getDireccion());

        }
        return clienteRepository.save(clieteexistente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);

    }
}
