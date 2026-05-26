package com.example.adt6_practica_examen.service;

import com.example.adt6_practica_examen.model.Coche;
import com.example.adt6_practica_examen.model.dto.CocheRequestDTO;
import com.example.adt6_practica_examen.model.dto.CocheResponseDTO;

import java.util.List;

public interface ICocheService {

    CocheResponseDTO registrar(CocheRequestDTO coche) throws Exception;
    CocheResponseDTO modificar(CocheRequestDTO coche) throws Exception;
    List<CocheResponseDTO> listar() throws Exception;

    List<CocheResponseDTO> listarPorMarca(String marca) throws Exception;
    CocheResponseDTO findByMatricula(String matricula) throws Exception;
    void deleteCocheByMatricula(String matricula) throws Exception;
    List<CocheResponseDTO> findByPrecioRange(Double minPrecio, Double maxPrecio) throws Exception;
    List<CocheResponseDTO> findBajoKilometraje(Integer km) throws Exception;

}
