package com.example.ejemplo_examen.controller;

import com.example.ejemplo_examen.model.Pasajero;
import com.example.ejemplo_examen.model.dto.PasajeroRequestDTO;
import com.example.ejemplo_examen.model.dto.PasajeroResponseDTO;
import com.example.ejemplo_examen.model.dto.RecaudacionResponseDTO;
import com.example.ejemplo_examen.service.IPasajeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    @Autowired
    private IPasajeroService service;

    @GetMapping("/listarPasajeros/{codigo}")
    public ResponseEntity<List<PasajeroResponseDTO>> listarPasajerosCodigo(@PathVariable String codigo) {
        try {
            List<PasajeroResponseDTO> pasajeros = service.listarPasajerosCodigo(codigo);
            return new ResponseEntity<>(pasajeros, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/agregarPasajero")
    public ResponseEntity<Pasajero> agregarPasajero(@Valid @RequestBody PasajeroRequestDTO pasajeroDTO) {
        try {
            Pasajero pasajero = service.agregarPasajero(pasajeroDTO);
            return new ResponseEntity<>(pasajero, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerRecaudacion/{codigo}")
    public ResponseEntity<RecaudacionResponseDTO> obtenerTotal(@PathVariable String codigo) {
        try {
            RecaudacionResponseDTO totalDTO = service.obtenerTotal(codigo);
            return new ResponseEntity<>(totalDTO, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
