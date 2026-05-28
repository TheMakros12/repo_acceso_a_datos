package com.example.ejemplo_examen_empresas.service;

import com.example.ejemplo_examen_empresas.model.dto.EmpleadoRequestDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpleadoResponseDTO;

public interface IEmpleadoService {

    EmpleadoResponseDTO contratarEmpleado(Integer idEmpresa, EmpleadoRequestDTO empleadoRequestDTO);

    EmpleadoResponseDTO buscarEmpleadoPorEmail(String email);

    EmpleadoResponseDTO actualizarEmpleado(Integer idEmpleado, EmpleadoRequestDTO empleadoRequestDTO);

}
