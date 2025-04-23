package com.example.mscatalogo.controller;


import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;


    @GetMapping()
    public ResponseEntity<List<Categoria>> list() {
        return ResponseEntity.ok().body(categoriaService.findAll());
    }
    @PostMapping()
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable(required = true) Long id, @RequestBody Categoria categoria){
        categoria.setId(id); // Asegurar que se actualice la categoría correcta
        return ResponseEntity.ok(categoriaService.update(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listById(@PathVariable(required = true) Long id){
        return ResponseEntity.ok().body(categoriaService.findById(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Long id){
        categoriaService.delete(id);
        return "Eliminacion Correcta";
    }
}
