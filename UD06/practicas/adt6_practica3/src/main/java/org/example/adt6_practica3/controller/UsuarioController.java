package org.example.adt6_practica3.controller;

import jakarta.validation.Valid;
import org.example.adt6_practica3.model.Usuario;
import org.example.adt6_practica3.model.dto.UsuarioRequestDTO;
import org.example.adt6_practica3.model.dto.UsuarioResponseDTO;
import org.example.adt6_practica3.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        List<UsuarioResponseDTO> lista = service.listar();

        // Código 200 OK para select
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> listarPorId(@PathVariable("id") Integer id) {
        UsuarioResponseDTO obj = service.listarPorId(id);

        if (obj == null) {
            // Código 404 No encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // Código 200 OK para select
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody UsuarioResponseDTO usuarioRequestDto) {
        Usuario obj = service.registrar(us);

        // Código 201 CREATED para insert
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable Integer id, @Valid @RequestBody UsuarioResponseDTO usuarioRequestDto) {
        Usuario obj = service.modificar(id, usuarioRequestDto);

        if (obj == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Código 200 OK para update
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);

        // Código 204 NOT CONTENT para delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

