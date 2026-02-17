package org.example.adt6_practica4.controller;

import jakarta.validation.Valid;
import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.FacturacionDTO;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;
import org.example.adt6_practica4.model.dto.ResumenDTO;
import org.example.adt6_practica4.service.ClienteServiceImpl;
import org.example.adt6_practica4.service.IReservaService;
import org.example.adt6_practica4.service.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @PostMapping("/nuevaReserva")
    public ResponseEntity<Reserva> crearReserva(@Valid @RequestBody ReservaRequestDTO dto) {
        try {
            Reserva reserva = reservaService.crearReserva(dto);
            return new ResponseEntity<>(reserva, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/cliente/eliminarReservas/{email}")
    public ResponseEntity<Void> eliminarReservas(@PathVariable("email") String email) {
        reservaService.eliminarReservasPorEmail(email);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    @GetMapping("/activas")
    public ResponseEntity<List<ReservaResponseDTO>> listarReservasActivas(
            @RequestParam("fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        List<ReservaResponseDTO> lista =
                reservaService.listarReservasActivasDesde(fecha);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/resumen")
    public ResponseEntity<ResumenDTO> resumenReservas() {
        ResumenDTO resumen = reservaService.contarReservasPorEstado();

        return new ResponseEntity<>(resumen, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{email}")
    public ResponseEntity<Void> eliminar(@PathVariable("email") String email) {
        try {
            reservaService.eliminar(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/facturacion")
    public ResponseEntity<Integer> facturacionTotal(@RequestParam("email") String email) {
        try {
            int fac = reservaService.facturacionTotal(email);
            if (fac == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/reservasConfirmadas")
    public ResponseEntity<List<ReservaResponseDTO>> reservasConfirmadas(@RequestParam(value = "fechaEntrada") String fechaEntrada) {
        LocalDate fehca = LocalDate.parse(fechaEntrada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<ReservaResponseDTO> lista = reservaService.listarReservasActivasDesde(fehca);

        if (lista == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/resumse")
    public ResponseEntity<ResumenDTO> resumen() {
        return new ResponseEntity<>(reservaService.confirmadasNoConfirmadas(), HttpStatus.OK);
    }

}
