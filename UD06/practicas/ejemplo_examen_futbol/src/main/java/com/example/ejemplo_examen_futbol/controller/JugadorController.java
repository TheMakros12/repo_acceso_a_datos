package com.example.ejemplo_examen_futbol.controller;

import com.example.ejemplo_examen_futbol.model.dto.JugadorRequestDTO;
import com.example.ejemplo_examen_futbol.model.dto.JugadorResponseDTO;
import com.example.ejemplo_examen_futbol.service.IJugadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/equipos/{equipoId}/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorService service;

    // 2. - Fichar a un Jugador para un Equipo
    @PostMapping
    public ResponseEntity<JugadorResponseDTO> ficharJugador(@PathVariable("equipoId") Integer equipoId, @Valid @RequestBody JugadorRequestDTO jugadorRequestDTO) {
        try {
            JugadorResponseDTO nuevoJugador = service.ficharJugador(equipoId, jugadorRequestDTO);
            return new ResponseEntity<>(nuevoJugador, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 3. - Obtener la plantilla completa de un Equipo
    @GetMapping
    public ResponseEntity<List<JugadorResponseDTO>> listarPlantilla(@PathVariable("equipoId") Integer equipoId) {
        try {
            List<JugadorResponseDTO> jugadores = service.obtenerPlantilla(equipoId);
            return new ResponseEntity<>(jugadores, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
