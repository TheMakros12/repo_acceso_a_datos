package com.example.ejemplo_examen_autores.controller;

import com.example.ejemplo_examen_autores.model.GeneroLibro;
import com.example.ejemplo_examen_autores.model.dto.AutorRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.AutorResponseDTO;
import com.example.ejemplo_examen_autores.service.IAutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private IAutorService service;

    @PostMapping("/registrarAutor")
    public ResponseEntity<AutorResponseDTO> registrarAutor(@Valid @RequestBody AutorRequestDTO autorRequestDTO) {
        try {
            AutorResponseDTO autor = service.registrarAutor(autorRequestDTO);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarAutores")
    public ResponseEntity<List<AutorResponseDTO>> listarAutores() {
        try {
            List<AutorResponseDTO> autores = service.listarAutores();
            return new ResponseEntity<>(autores, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/autoresPorGenero")
    public ResponseEntity<List<AutorResponseDTO>> buscarAutoresPorGenero(@RequestParam GeneroLibro genero) {
        try {
            List<AutorResponseDTO> autoresPorGenero = service.buscarAutoresPorGeneroLibro(genero);
            return new ResponseEntity<>(autoresPorGenero, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
