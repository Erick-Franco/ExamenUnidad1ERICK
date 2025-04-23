package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Categoria;
import com.example.mscatalogo.entity.Producto;
import com.example.mscatalogo.service.CategoriaService;
import com.example.mscatalogo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<List<Producto>> list() {
        return ResponseEntity.ok().body(productoService.findAll());
    }
    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable(required = true) Long id, @RequestBody Producto producto){
        producto.setId(id); // Asegurar que se actualice la categoría correcta
        return ResponseEntity.ok(productoService.update(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listById(@PathVariable(required = true) Long id){
        return ResponseEntity.ok().body(productoService.findById(id).get());
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Long id){
        productoService.delete(id);
        return "Eliminacion Correcta";
    }

}
