package com.example.ejemplo_examen_biblioteca.controller;

import com.example.ejemplo_examen_biblioteca.model.dto.LibroResponseDTO;
import com.example.ejemplo_examen_biblioteca.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private ILibroService service;

    // 3. - Buscar un Libro por ISBN.
    @GetMapping("/busqueda")
    public ResponseEntity<LibroResponseDTO> buscarLibroPorIsbn(@RequestParam String isbn) {
        LibroResponseDTO libro = service.buscarLibroPorIsbn(isbn);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    // 4. - Cambiar el Estado de un Libro.
    @PatchMapping("/{idLibro}/cambiarEstado")
    public ResponseEntity<LibroResponseDTO> cambiarEstado(@PathVariable Integer idLibro, @RequestParam String estado) {
        LibroResponseDTO libro = service.actualizarEstado(idLibro, estado);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

}
