package org.example.adt6_practica2.controller;

import org.example.adt6_practica2.model.Hotel;
import org.example.adt6_practica2.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Hotel>> listar() {
        List<Hotel> lista = service.listar();

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Hotel> registrar(@RequestBody Hotel hotel) {
        Hotel obj = service.registrar(hotel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Hotel> modificar(@RequestBody Hotel hotel) {
        Hotel obj = service.modificar(hotel);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> buscar(@RequestParam(required = false) String localidad,
                                              @RequestParam(required = false) String categoria) {
        List<Hotel> lista = service.listarPorLocalidadYCategoria(localidad, categoria);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
