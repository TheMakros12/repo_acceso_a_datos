package com.example.ejemplo_examen_futbol.controller;

import com.example.ejemplo_examen_futbol.model.dto.EquipoRequestDTO;
import com.example.ejemplo_examen_futbol.model.dto.EquipoResponseDTO;
import com.example.ejemplo_examen_futbol.model.dto.JugadorResponseDTO;
import com.example.ejemplo_examen_futbol.service.IEquipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private IEquipoService service;

    // 1. - Registrar un nuevo Equipo.
    @PostMapping
    public ResponseEntity<EquipoResponseDTO> registrarEquipo(@Valid @RequestBody EquipoRequestDTO equipoRequestDTO) {
        try {
            EquipoResponseDTO nuevoEquipo = service.registrarEquipo(equipoRequestDTO);
            return new ResponseEntity<>(nuevoEquipo, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ha ocurrido un error al registrar un nuevo Equipo: " + e.getMessage(), e);
        }
    }

    // 4. - Buscar Equipos cuyo salario total supere un importe
    @GetMapping("/busqueda")
    public ResponseEntity<List<EquipoResponseDTO>> listarEquiposPorSalarioMinimo(@RequestParam("salarioMinimo") BigDecimal salarioMinimo) {
        try {
            List<EquipoResponseDTO> equiposPorSalarioMinimo = service.buscarEquiposPorSalarioMinimo(salarioMinimo);
            return new ResponseEntity<>(equiposPorSalarioMinimo, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ha ocurrido un error al listar Equipos por salario mínimo. " + e.getMessage(), e);
        }
    }


}
