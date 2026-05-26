package com.example.ejemplo_examen.controller;

import com.example.ejemplo_examen.service.IVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private IVueloService service;

    @PutMapping("/actualizarVuelo/{codigo}")
    public ResponseEntity<String> actualizarEstado(@PathVariable String codigo) throws Exception {
        try {
            String estado = service.actualizarEstado(codigo);
            return new ResponseEntity<>(estado, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
