package com.example.ejemplo_examen_soporte.controller;

import com.example.ejemplo_examen_soporte.model.dto.TicketRequestDTO;
import com.example.ejemplo_examen_soporte.model.dto.TicketResponseDTO;
import com.example.ejemplo_examen_soporte.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private ITicketService service;

    //3. - Buscar un Ticket por su Nombre.
    @GetMapping("/busqueda")
    public ResponseEntity<TicketResponseDTO> buscarTicketPorNombre(@RequestParam String nombre) {
        TicketResponseDTO ticket = service.buscarTicketPorTitulo(nombre);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    //4. - Avanzar el Estado de un Ticket.
    @PatchMapping("/{idTicket}/avanzarEstado")
    public ResponseEntity<TicketResponseDTO> actualizarEstado(@PathVariable Integer idTicket) {
        TicketResponseDTO ticket = service.actualizarEstado(idTicket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

}
