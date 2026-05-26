package com.example.ejemplo_examen_autores.service;

import com.example.ejemplo_examen_autores.model.GeneroLibro;
import com.example.ejemplo_examen_autores.model.dto.AutorRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.AutorResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface IAutorService {

    AutorResponseDTO registrarAutor(AutorRequestDTO autorRequestDTO) throws Exception;

    List<AutorResponseDTO> listarAutores() throws Exception;

    List<AutorResponseDTO> buscarAutoresPorGeneroLibro(GeneroLibro genero) throws Exception;

}
