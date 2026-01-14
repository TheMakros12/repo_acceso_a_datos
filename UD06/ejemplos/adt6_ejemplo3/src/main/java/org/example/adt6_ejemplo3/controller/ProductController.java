package org.example.adt6_ejemplo3.controller;

import jakarta.validation.Valid;
import org.example.adt6_ejemplo3.model.Product;
import org.example.adt6_ejemplo3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> listar() {
        List<Product> listaProductos = service.listar();

        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> listarPorId(@PathVariable("id") Integer id,
                                               Principal principal) {
        Product product = service.listarPorId(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> registrar(@Valid @RequestBody Product product) {
        Product insertProduct = service.registrar(product);

        return new ResponseEntity<>(insertProduct, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> modificar(@Valid @RequestBody Product product) {
        Product updateProduct = service.modificar(product);

        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Product>> listarPorCategoria(@RequestParam(value = "categoria") String categoria) {
        List<Product> listaProductos = service.listarPorCategoria(categoria);

        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Product>> listarPorFecha(
            @RequestParam(value = "fecha1") LocalDate fecha1,
            @RequestParam(value = "fecha2") LocalDate fecha2) {
        List<Product> listaProductos = service.listarPorFecha(fecha1, fecha2);

        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

}
