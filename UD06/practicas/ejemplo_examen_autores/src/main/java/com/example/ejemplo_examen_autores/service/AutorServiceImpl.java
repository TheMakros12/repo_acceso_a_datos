package com.example.ejemplo_examen_autores.service;

import com.example.ejemplo_examen_autores.model.Autor;
import com.example.ejemplo_examen_autores.model.GeneroLibro;
import com.example.ejemplo_examen_autores.model.dto.AutorRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.AutorResponseDTO;
import com.example.ejemplo_examen_autores.repository.IAutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorServiceImpl implements IAutorService {

    @Autowired
    private IAutorRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AutorResponseDTO registrarAutor(AutorRequestDTO autorRequestDTO) throws Exception {
        Autor nuevoAutor = modelMapper.map(autorRequestDTO, Autor.class);

        Autor autorGuardado = repo.save(nuevoAutor);

        return modelMapper.map(autorGuardado, AutorResponseDTO.class);
    }

    @Override
    public List<AutorResponseDTO> listarAutores() throws Exception {
        List<Autor> autores = repo.findAll();

        return autores.stream()
                .map(autor -> modelMapper.map(autor, AutorResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AutorResponseDTO> buscarAutoresPorGeneroLibro(GeneroLibro genero) throws Exception {
        List<Autor> autoresPorGenero = repo.findAutoresByGenero(genero);

        return autoresPorGenero.stream()
                .map(autor -> modelMapper.map(autor, AutorResponseDTO.class))
                .collect(Collectors.toList());
    }

}
