package com.example.ejemplo_examen_biblioteca.service;

import com.example.ejemplo_examen_biblioteca.model.Biblioteca;
import com.example.ejemplo_examen_biblioteca.model.dto.BibliotecaRequestDTO;
import com.example.ejemplo_examen_biblioteca.model.dto.BibliotecaResponseDTO;
import com.example.ejemplo_examen_biblioteca.repository.IBibliotecaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaServiceImpl implements IBibliotecaService {

    @Autowired
    private IBibliotecaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BibliotecaResponseDTO crearBiblioteca(BibliotecaRequestDTO bibliotecaRequestDTO) {
        Biblioteca biblioteca = modelMapper.map(bibliotecaRequestDTO, Biblioteca.class);

        Biblioteca bibliotecaCreada = repository.save(biblioteca);

        return modelMapper.map(bibliotecaCreada, BibliotecaResponseDTO.class);
    }

}
