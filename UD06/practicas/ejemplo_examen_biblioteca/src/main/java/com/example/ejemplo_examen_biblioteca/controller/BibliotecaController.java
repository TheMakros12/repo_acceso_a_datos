package com.example.ejemplo_examen_biblioteca.controller;

import com.example.ejemplo_examen_biblioteca.model.dto.BibliotecaRequestDTO;
import com.example.ejemplo_examen_biblioteca.model.dto.BibliotecaResponseDTO;
import com.example.ejemplo_examen_biblioteca.model.dto.LibroRequestDTO;
import com.example.ejemplo_examen_biblioteca.model.dto.LibroResponseDTO;
import com.example.ejemplo_examen_biblioteca.service.IBibliotecaService;
import com.example.ejemplo_examen_biblioteca.service.ILibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaController {

    @Autowired
    private IBibliotecaService serviceBiblioteca;

    @Autowired
    private ILibroService serviceLibro;

    // 1. - Crear una nueva Biblioteca.
    @PostMapping
    public ResponseEntity<BibliotecaResponseDTO> crearBiblioteca(@Valid @RequestBody BibliotecaRequestDTO bibliotecaRequestDTO) {
        BibliotecaResponseDTO biblioteca = serviceBiblioteca.crearBiblioteca(bibliotecaRequestDTO);
        return new ResponseEntity<>(biblioteca, HttpStatus.CREATED);
    }

    // 2. - Agregar un nuevo Libro al catálogo de una Biblioteca.
    @PostMapping("/{idBiblioteca}/libros")
    public ResponseEntity<LibroResponseDTO> agregarLibro(@PathVariable Integer idBiblioteca, @Valid @RequestBody LibroRequestDTO libroRequestDTO) {
        LibroResponseDTO libro = serviceLibro.agregarLibro(idBiblioteca, libroRequestDTO);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }

}
