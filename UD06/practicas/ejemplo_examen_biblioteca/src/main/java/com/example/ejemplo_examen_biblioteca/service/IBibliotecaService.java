package com.example.ejemplo_examen_biblioteca.service;

import com.example.ejemplo_examen_biblioteca.model.dto.BibliotecaRequestDTO;
import com.example.ejemplo_examen_biblioteca.model.dto.BibliotecaResponseDTO;

public interface IBibliotecaService {

    BibliotecaResponseDTO crearBiblioteca(BibliotecaRequestDTO bibliotecaRequestDTO);


}
