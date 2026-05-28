package org.example.ejemplo_examen_curso.controller;

import jakarta.validation.Valid;
import org.example.ejemplo_examen_curso.model.dto.EstudianteRequestDTO;
import org.example.ejemplo_examen_curso.model.dto.EstudianteResponseDTO;
import org.example.ejemplo_examen_curso.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @GetMapping("/estudiantes/busqueda")
    public ResponseEntity<EstudianteResponseDTO> buscarEstudiantePorEmail(@RequestParam String email) {
        EstudianteResponseDTO estudiante = service.buscarPorEmail(email);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @PutMapping("/estudiantes/{idEstudiante}")
    public ResponseEntity<EstudianteResponseDTO> actualizarEstudiante(@PathVariable Integer idEstudiante, @Valid @RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        EstudianteResponseDTO estudiante = service.actualizarEstudiante(idEstudiante, estudianteRequestDTO);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @DeleteMapping("/estudiantes/{idEstudiante}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Integer idEstudiante) {
        service.eliminarEstudiante(idEstudiante);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
