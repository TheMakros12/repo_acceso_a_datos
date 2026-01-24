package org.example.adt6_practica1.controller;

import org.example.adt6_practica1.model.Vuelo;
import org.example.adt6_practica1.service.VueloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Vuelo>> listar() {
        List<Vuelo> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vuelo> registrar(@RequestBody Vuelo vuelo) {
        Vuelo v = service.registrar(vuelo);
        return new ResponseEntity<>(v, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Vuelo> modificar(@RequestBody Vuelo vuelo) {
        Vuelo v = service.modificar(vuelo);
        return new ResponseEntity<>(vuelo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/eliminarPorDestino")
    public ResponseEntity<Void> eliminarPorDestion(@RequestParam("destino") String destino) {
        if (!service.existsByDestino(destino)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.eliminarPorDestino(destino);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Vuelo>> listaFiltrada(
            @RequestParam(value = "origen", required = false) String origen,
            @RequestParam(value = "destino", required = false) String destino,
            @RequestParam(value = "numEscalas", required = false) Integer numEscalas) {
        List<Vuelo> vuelos = service.buscar(origen, destino, numEscalas);
        if (vuelos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(vuelos, HttpStatus.OK);
        }
    }

}
