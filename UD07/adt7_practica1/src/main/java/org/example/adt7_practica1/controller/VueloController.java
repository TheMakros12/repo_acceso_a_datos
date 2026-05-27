package org.example.adt7_practica1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.adt7_practica1.model.Vuelo;
import org.example.adt7_practica1.service.VueloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
@Tag(name = "Vuelos", description = "Catálogo de Vuelos.")
public class VueloController {

    @Autowired
    private VueloServiceImpl service;

    @Operation(summary = "Obtiene el listado de vuelos.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Listado de productos.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Vuelo.class)))),
    })
    @GetMapping
    public ResponseEntity<List<Vuelo>> listar() {
        List<Vuelo> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Registra un nuevo vuelo.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Se registra el vuelo.",
                    content = @Content(schema = @Schema(implementation = Vuelo.class)))
    })
    @PostMapping
    public ResponseEntity<Vuelo> registrar(@RequestBody Vuelo vuelo) {
        Vuelo v = service.registrar(vuelo);
        return new ResponseEntity<>(v, HttpStatus.CREATED);
    }

    @Operation(summary = "Modifica un vuelos en el catálogo.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se modifica el vuelo.",
                    content = @Content(schema = @Schema(implementation = Vuelo.class))),
    })
    @PutMapping
    public ResponseEntity<Vuelo> modificar(@RequestBody Vuelo vuelo) {
        Vuelo v = service.modificar(vuelo);
        return new ResponseEntity<>(vuelo, HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un vuelo")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Se elimina el vuelo",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Elimina un vuelo por un destino.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Se elimina el vuelo dado su destino.",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
    })
    @DeleteMapping("/eliminarPorDestino")
    public ResponseEntity<Void> eliminarPorDestion(@RequestParam("destino") String destino) {
        if (!service.existsByDestino(destino)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.eliminarPorDestino(destino);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Obtiene el listado de vuelos filtrada.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Listado de productos filtrada segun el origen, destino y número de escalas.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = Vuelo.class)))),
    })
    @GetMapping("/buscar")
    public ResponseEntity<List<Vuelo>> listaFiltrada(
            @RequestParam(value = "origen", required = false) String origen,
            @RequestParam(value = "destino", required = false) String destino,
            @RequestParam(value = "numEscalas", required = false) Integer numEscalas) {
        List<Vuelo> vuelos = service.buscar(origen, destino, numEscalas);
        if (vuelos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(vuelos, HttpStatus.OK);
        }
    }

}
