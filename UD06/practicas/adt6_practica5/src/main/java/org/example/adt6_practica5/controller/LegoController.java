package org.example.adt6_practica5.controller;

import org.example.adt6_practica5.model.Lego;
import org.example.adt6_practica5.model.dto.PiezasPorCategoriaDTO;
import org.example.adt6_practica5.model.dto.TotalPiezasDTO;
import org.example.adt6_practica5.service.ILegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legos")
public class LegoController {

    @Autowired
    private ILegoService service;

    @PostMapping
    public Lego save(@RequestBody Lego lego){
        return service.save(lego);
    }

    @PutMapping
    public Lego update(@RequestBody Lego lego){
        return service.update(lego);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping
    public List<Lego> findAll(){
        return service.findAll();
    }

    @GetMapping("/categoria")
    public List<Lego> findById(@RequestParam(value = "categoria") String categoria){
        return service.findByCategoria(categoria);
    }

    @GetMapping("/totalPiezas")
    public TotalPiezasDTO getTotalPiezas(){
        return service.getTotalPiezas();
    }

    @GetMapping("/piezas")
    public PiezasPorCategoriaDTO getPiezasPorCategoria(@RequestParam(value = "categoria") String categoria) {
        return service.getPiezasPorCategoria(categoria);
    }

}
