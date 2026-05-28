package com.example.ejemplo_examen_biblioteca.service;

import com.example.ejemplo_examen_biblioteca.model.dto.LibroRequestDTO;
import com.example.ejemplo_examen_biblioteca.model.dto.LibroResponseDTO;

public interface ILibroService {

    LibroResponseDTO agregarLibro(Integer idBiblioteca, LibroRequestDTO libroRequestDTO);

    LibroResponseDTO buscarLibroPorIsbn(String isbn);

    LibroResponseDTO actualizarEstado(Integer idLibro, String estado);

}
