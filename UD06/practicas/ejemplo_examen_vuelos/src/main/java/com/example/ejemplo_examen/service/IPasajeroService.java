package com.example.ejemplo_examen.service;

import com.example.ejemplo_examen.model.Pasajero;
import com.example.ejemplo_examen.model.dto.PasajeroRequestDTO;
import com.example.ejemplo_examen.model.dto.PasajeroResponseDTO;
import com.example.ejemplo_examen.model.dto.RecaudacionResponseDTO;

import java.util.List;

public interface IPasajeroService {

    List<PasajeroResponseDTO> listarPasajerosCodigo(String codifo) throws Exception;

    Pasajero agregarPasajero(PasajeroRequestDTO pasajeroRequestDTO) throws Exception;

    RecaudacionResponseDTO obtenerTotal(String codigo) throws Exception;

}
