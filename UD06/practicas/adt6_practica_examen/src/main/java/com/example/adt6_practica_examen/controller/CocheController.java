package com.example.adt6_practica_examen.controller;

import com.example.adt6_practica_examen.model.dto.CocheRequestDTO;
import com.example.adt6_practica_examen.model.dto.CocheResponseDTO;
import com.example.adt6_practica_examen.service.ICocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coches")
public class CocheController {

    @Autowired
    private ICocheService service;

    @PostMapping
    public ResponseEntity<CocheResponseDTO> registrar(@RequestBody CocheRequestDTO cocheRequestDTO) {
        try {
            CocheResponseDTO c = service.registrar(cocheRequestDTO);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<CocheResponseDTO> modificar(@RequestBody CocheRequestDTO cocheRequestDTO) {
        try {
            CocheResponseDTO c = service.modificar(cocheRequestDTO);
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<CocheResponseDTO>> listar() {
        try {
            List<CocheResponseDTO> listaCoches = service.listar();
            return new ResponseEntity<>(listaCoches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/marca")
    public ResponseEntity<List<CocheResponseDTO>> listarPorMarca(@RequestParam(value = "marca") String marca) {
        try {
            List<CocheResponseDTO> listaMarca = service.listarPorMarca(marca);
            return new ResponseEntity<>(listaMarca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/matricula")
    public ResponseEntity<CocheResponseDTO> findByMatricula(@RequestParam(value = "matricula") String matricula) {
        try {
            CocheResponseDTO c = service.findByMatricula(matricula);
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/precio-range")
    public ResponseEntity<List<CocheResponseDTO>> findByPrecioRange(@RequestParam Double minPrecio,
                                                                    @RequestParam Double maxPrecio) {
        try {
            List<CocheResponseDTO> coches = service.findByPrecioRange(minPrecio, maxPrecio);
            return new ResponseEntity<>(coches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/bajo-kilometraje")
    public ResponseEntity<List<CocheResponseDTO>> findBajoKilometraje(@RequestParam Integer km) {
        try {
            List<CocheResponseDTO> coches = service.findBajoKilometraje(km);
            return new ResponseEntity<>(coches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteCocheByMatricula(@PathVariable String matricula) {
        try {
            service.deleteCocheByMatricula(matricula);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}