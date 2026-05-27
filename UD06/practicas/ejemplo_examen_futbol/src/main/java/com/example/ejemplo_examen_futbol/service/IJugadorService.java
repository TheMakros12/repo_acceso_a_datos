package com.example.ejemplo_examen_futbol.service;

import com.example.ejemplo_examen_futbol.model.dto.JugadorRequestDTO;
import com.example.ejemplo_examen_futbol.model.dto.JugadorResponseDTO;

import java.util.List;

public interface IJugadorService {

    JugadorResponseDTO ficharJugador(Integer idEquipo, JugadorRequestDTO jugadorRequestDTO);

    List<JugadorResponseDTO> obtenerPlantilla(Integer idEquipo);

}
