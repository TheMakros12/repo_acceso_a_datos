package com.example.ejemplo_examen_empresas.controller;

import com.example.ejemplo_examen_empresas.model.dto.EmpleadoRequestDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpleadoResponseDTO;
import com.example.ejemplo_examen_empresas.service.IEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService service;

    @GetMapping("/busqueda")
    public ResponseEntity<EmpleadoResponseDTO> buscarEmpleadoPorEmail(@RequestParam String email) {
        EmpleadoResponseDTO empleado = service.buscarEmpleadoPorEmail(email);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PutMapping("/{idEmpleado}")
    public ResponseEntity<EmpleadoResponseDTO> actualizarEmpleado(@PathVariable Integer idEmpleado, @Valid @RequestBody EmpleadoRequestDTO empleadoRequestDTO) {
        EmpleadoResponseDTO empleado = service.actualizarEmpleado(idEmpleado, empleadoRequestDTO);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

}
