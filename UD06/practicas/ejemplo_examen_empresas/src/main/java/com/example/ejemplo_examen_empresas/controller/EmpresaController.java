package com.example.ejemplo_examen_empresas.controller;

import com.example.ejemplo_examen_empresas.model.dto.EmpleadoRequestDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpleadoResponseDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpresaRequestDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpresaResponseDTO;
import com.example.ejemplo_examen_empresas.service.IEmpleadoService;
import com.example.ejemplo_examen_empresas.service.IEmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private IEmpresaService serviceEmpresa;

    @Autowired
    private IEmpleadoService serviceEmpleado;

    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> crearEmpresa(@Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
        try {
            EmpresaResponseDTO empresa = serviceEmpresa.crearEmpresa(empresaRequestDTO);
            return new ResponseEntity<>(empresa, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{idEmpresa}/empleados")
    public ResponseEntity<EmpleadoResponseDTO> contratarEmpleado(@PathVariable Integer idEmpresa, @Valid @RequestBody EmpleadoRequestDTO empleadoRequestDTO) {
        EmpleadoResponseDTO empleado = serviceEmpleado.contratarEmpleado(idEmpresa, empleadoRequestDTO);
        return new ResponseEntity<>(empleado, HttpStatus.CREATED);
    }

}
