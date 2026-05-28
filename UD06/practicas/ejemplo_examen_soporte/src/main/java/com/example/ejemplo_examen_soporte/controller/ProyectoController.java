package com.example.ejemplo_examen_soporte.controller;

import com.example.ejemplo_examen_soporte.model.dto.ProyectoRequestDTO;
import com.example.ejemplo_examen_soporte.model.dto.ProyectoResponseDTO;
import com.example.ejemplo_examen_soporte.model.dto.TicketRequestDTO;
import com.example.ejemplo_examen_soporte.model.dto.TicketResponseDTO;
import com.example.ejemplo_examen_soporte.service.IProyectoService;
import com.example.ejemplo_examen_soporte.service.ITicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private IProyectoService serviceProyecto;

    @Autowired
    private ITicketService serviceTicket;

    // 1. - Crear un nuevo Proyecto.
    @PostMapping
    public ResponseEntity<ProyectoResponseDTO> crearProyecto(@Valid @RequestBody ProyectoRequestDTO proyectoRequestDTO) {
        ProyectoResponseDTO proyecto = serviceProyecto.crearProyecto(proyectoRequestDTO);
        return new ResponseEntity<>(proyecto, HttpStatus.CREATED);
    }

    // 2. - Crear un nuevo Ticket en un Proyecto.
    @PostMapping("/{idProyecto}/tickets")
    public ResponseEntity<TicketResponseDTO> crearTicket(@PathVariable Integer idProyecto, @Valid @RequestBody TicketRequestDTO ticketRequestDTO) {
        TicketResponseDTO ticket = serviceTicket.crearNuevoTicket(idProyecto, ticketRequestDTO);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

}
