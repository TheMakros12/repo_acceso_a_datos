package org.example.adt6_practica4.controller;

import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.service.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaServiceImpl service;

    @GetMapping("/cliente/{email}")
    public List<Reserva> obtenerReservas(@PathVariable String email) {
        return service.obtenerReservasPorEmail(email);
    }
}
