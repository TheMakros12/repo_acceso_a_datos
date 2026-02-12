package org.example.adt6_practica4.controller;

import jakarta.validation.Valid;
import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.FacturacionDTO;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;
import org.example.adt6_practica4.service.ClienteServiceImpl;
import org.example.adt6_practica4.service.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaServiceImpl reservaService;

    @GetMapping("/cliente/{email}")
    public ResponseEntity<List<ReservaResponseDTO>> obtenerReservas(@PathVariable("email") String email) {
        List<ReservaResponseDTO> lista = reservaService.obtenerReservasPorEmail(email);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/facturacion")
    public ResponseEntity<FacturacionDTO> obtenerFacturacion(@RequestParam("email") String email) {
        Integer total = reservaService.obtenerFacturacionPorEmail(email);

        if ( total == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(new FacturacionDTO(total), HttpStatus.OK);
        }
    }

    @PostMapping("/nuevaReserva")
    public ResponseEntity<Reserva> crearReserva(@Valid @RequestBody ReservaRequestDTO dto) {
        Reserva reserva = reservaService.crearReserva(dto);
        return new ResponseEntity<>(reserva, HttpStatus.CREATED);
    }

    @DeleteMapping("/cliente/eliminarReservas/{email}")
    public ResponseEntity<Void> eliminarReservas(@PathVariable("email") String email) {
        reservaService.eliminarReservasPorEmail(email);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
