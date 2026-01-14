package com.mardurbla.controller;

import com.mardurbla.model.Paciente;
import com.mardurbla.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public String saludar() {
        Paciente p = new Paciente();
        p.setId(1);
        p.setNombre("Marcos");

        return service.saludar(p);
    }

}
