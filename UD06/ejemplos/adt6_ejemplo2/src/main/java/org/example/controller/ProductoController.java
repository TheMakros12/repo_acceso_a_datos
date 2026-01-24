package org.example.controller;

import org.example.model.Producto;
import org.example.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl service;

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Producto listarPorId(@PathVariable("id") Integer id){
        return service.listarPorId(id);
    }

    @PostMapping
    public Producto registrar(@RequestBody Producto p){
        return service.registrar(p);
    }

    @PutMapping
    public Producto modificar(@RequestBody Producto p){
        return service.modificar(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
    }

    @GetMapping("/buscar")
    public List<Producto> listarPorCategoria(@RequestParam(value = "categoria") String categotia) {
        return service.listarPorCategoria(categotia);
    }

    @GetMapping("/fecha")
    public List<Producto> listarPorFecha(@RequestParam(value = "fecha1") String fecha1,
                                         @RequestParam(value = "fecha1") String fecha2) {
        return service.listarPorFecha(
                LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
