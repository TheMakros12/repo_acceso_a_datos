package org.example.adt6_practica2.controller;

import org.example.adt6_practica2.model.Habitacion;
import org.example.adt6_practica2.service.HabitacionServiceImpl;
import org.example.adt6_practica2.service.IHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/habaticiones")
public class HabitacionController {

    @Autowired
    private HabitacionServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Habitacion>> listar() {
        List<Habitacion> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Habitacion> registrar(@RequestBody Habitacion habitacion) {
        try {
            Habitacion obj = service.registrar(habitacion);
            return new ResponseEntity<>(obj,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Habitacion> modificar(@RequestBody Habitacion habitacion) {
        Habitacion obj = service.modificar(habitacion);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{idHotel}")
    public ResponseEntity<List<Habitacion>> listarPorHotel(@PathVariable("idHotel") Integer idHotel) {
        List<Habitacion> lista = service.listarHabitaciones(idHotel);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{idHotel}/libres")
    public ResponseEntity<List<Habitacion>> listarPorHotelLibres(@PathVariable("idHotel") Integer idHotel) {
        List<Habitacion> lista = service.listarHabitacionesLibres(idHotel);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PutMapping("{id}/ocupadas")
    public ResponseEntity<Habitacion> modificarOcupacion(@PathVariable Integer id) {
        Habitacion obj = service.modificarOcupacion(id);
        if (obj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
    }

}
