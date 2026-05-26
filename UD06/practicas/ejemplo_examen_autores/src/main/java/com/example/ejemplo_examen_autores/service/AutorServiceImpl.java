package com.example.ejemplo_examen_autores.service;

import com.example.ejemplo_examen_autores.model.Autor;
import com.example.ejemplo_examen_autores.model.GeneroLibro;
import com.example.ejemplo_examen_autores.model.dto.AutorRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.AutorResponseDTO;
import com.example.ejemplo_examen_autores.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements IAutorService {

    @Autowired
    private IAutorRepository repo;

    @Override
    public AutorResponseDTO registrarAutor(AutorRequestDTO autorRequestDTO) throws Exception {

    }

    @Override
    public List<AutorResponseDTO> listarAutores() throws Exception {
        return List.of();
    }

    @Override
    public List<AutorResponseDTO> buscarAutoresPorGeneroLibro(GeneroLibro genero) throws Exception {
        return List.of();
    }
}
