package com.example.ejemplo_examen_autores.controller;

import com.example.ejemplo_examen_autores.model.dto.LibroRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.LibroResponseDTO;
import com.example.ejemplo_examen_autores.service.ILibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LibroController {

    @Autowired
    private ILibroService service;

    @PostMapping("/autores/{idAutor}/libros")
    public ResponseEntity<LibroResponseDTO> anyadirLibro(@PathVariable Integer idAutor,
                                                         @Valid @RequestBody
                                                         LibroRequestDTO libroRequestDTO) {
        try {
            LibroResponseDTO libro = service.anyadirLibroAAutor(idAutor, libroRequestDTO);
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/libros/busqueda")
    public ResponseEntity<List<LibroResponseDTO>> buscarPorRango(@RequestParam Integer desde,
                                                                 @RequestParam Integer hasta) {
        try {
            List<LibroResponseDTO> libros = service.buscarLibrosPorRangoDeAnyos(desde, hasta);
            return new ResponseEntity<>(libros, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Void> retirarLibro(@PathVariable Integer id) {
        try {
            service.retirarLibro(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
