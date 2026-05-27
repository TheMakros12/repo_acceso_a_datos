package com.example.ejemplo_examen_futbol.service;

import com.example.ejemplo_examen_futbol.model.dto.EquipoRequestDTO;
import com.example.ejemplo_examen_futbol.model.dto.EquipoResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IEquipoService {

    EquipoResponseDTO registrarEquipo(EquipoRequestDTO equipoRequestDTO);

    List<EquipoResponseDTO> buscarEquiposPorSalarioMinimo(BigDecimal salarioMinimo);

}
