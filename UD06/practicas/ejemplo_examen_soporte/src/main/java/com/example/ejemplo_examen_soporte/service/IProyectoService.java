package com.example.ejemplo_examen_soporte.service;

import com.example.ejemplo_examen_soporte.model.dto.ProyectoRequestDTO;
import com.example.ejemplo_examen_soporte.model.dto.ProyectoResponseDTO;

public interface IProyectoService {

    ProyectoResponseDTO crearProyecto(ProyectoRequestDTO proyectoRequestDTO);

}
