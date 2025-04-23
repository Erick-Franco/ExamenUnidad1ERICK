package com.example.mscliente.controller;

import com.example.mscliente.entity.Cliente;
import com.example.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok().body(clienteService.findAll());
    }
    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable(required = true) Long id, @RequestBody Cliente cliente){
        cliente.setId(id); // Asegurar que se actualice la categoría correcta
        return ResponseEntity.ok(clienteService.update(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listById(@PathVariable(required = true) Long id){
        return ResponseEntity.ok().body(clienteService.findById(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Long id){
        clienteService.delete(id);
        return "Eliminacion Correcta";
    }

}
