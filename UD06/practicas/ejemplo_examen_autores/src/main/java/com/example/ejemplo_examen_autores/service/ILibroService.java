package com.example.ejemplo_examen_autores.service;

import com.example.ejemplo_examen_autores.model.GeneroLibro;
import com.example.ejemplo_examen_autores.model.dto.LibroRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.LibroResponseDTO;

import java.util.List;

public interface ILibroService {

    LibroResponseDTO anyadirLibroAAutor(Integer idautor, LibroRequestDTO libroRequestDTO) throws Exception;

    List<LibroResponseDTO> obtenerLibrosPorAutor(Integer idAutor) throws Exception;

    List<LibroResponseDTO> buscarLibrosPorGenero(GeneroLibro generoLibro) throws Exception;

    List<LibroResponseDTO> buscarLibrosPorRangoDeAnyos(Integer desde, Integer hasta) throws Exception;

    void retirarLibro(Integer idLibro) throws Exception;

}
