package org.example.adt6_practica4.controller;

import jakarta.validation.Valid;
import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;
import org.example.adt6_practica4.model.dto.ResumenDTO;
import org.example.adt6_practica4.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService service;

    @PostMapping("/nuevaReserva")
    public ResponseEntity<ReservaRequestDTO> registrar(@Valid @RequestBody ReservaRequestDTO reservaRequestDto) {
        try {
            ReservaRequestDTO dto = service.registrar(reservaRequestDto);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/eliminar/{email}")
    public ResponseEntity<Void> eliminarReservasPorEmail(@PathVariable("email") String email) {
        try {
            service.eliminarReservaPorEmail(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/obtenerFacturacion")
    public ResponseEntity<Integer> obtenerFacturacion(@RequestParam("email") String email) {
        try {
            int facturacion = service.obtenerFacturacion(email);

            if ( facturacion == 0 )
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(facturacion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/obtenerReservasConfirmadas")
    public ResponseEntity<List<ReservaResponseDTO>> listarReservasConfirmadas(@RequestParam LocalDate fechaEntrada) {
        List<ReservaResponseDTO> reservas = service.listarReservasConfirmadas(fechaEntrada);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/contarPorDisponibilidad")
    public ResponseEntity<ResumenDTO> contarPorDisponibilidad() {
        List<Reserva> DTOConfirmado = service.listarPorConfirmacion(true);
        List<Reserva> DTONoConfirmado = service.listarPorConfirmacion(false);

        ResumenDTO resumenDTO = new ResumenDTO(DTOConfirmado.size(), DTONoConfirmado.size());

        return new ResponseEntity<>(resumenDTO, HttpStatus.OK);
    }

}
