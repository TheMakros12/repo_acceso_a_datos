package com.example.ejemplo_examen_biblioteca.service;

import com.example.ejemplo_examen_biblioteca.model.Biblioteca;
import com.example.ejemplo_examen_biblioteca.model.Estado;
import com.example.ejemplo_examen_biblioteca.model.Libro;
import com.example.ejemplo_examen_biblioteca.model.dto.LibroRequestDTO;
import com.example.ejemplo_examen_biblioteca.model.dto.LibroResponseDTO;
import com.example.ejemplo_examen_biblioteca.repository.IBibliotecaRepository;
import com.example.ejemplo_examen_biblioteca.repository.ILibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    private ILibroRepository repositoryLibro;

    @Autowired
    private IBibliotecaRepository repositoryBiblioteca;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LibroResponseDTO agregarLibro(Integer idBiblioteca, LibroRequestDTO libroRequestDTO) {
        Biblioteca biblioteca = repositoryBiblioteca.findById(idBiblioteca)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La Biblioteca con ID " + idBiblioteca + " no existe."));

        Libro libro = modelMapper.map(libroRequestDTO, Libro.class);
        libro.setBiblioteca(biblioteca);

        return modelMapper.map(libro, LibroResponseDTO.class);
    }

    @Override
    public LibroResponseDTO buscarLibroPorIsbn(String isbn) {
        Libro libro = repositoryLibro.findLibroByIsbn(isbn);
        if (libro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Libro con ISBN " + isbn + " no existe.");
        }

        return modelMapper.map(libro, LibroResponseDTO.class);
    }

    @Override
    public LibroResponseDTO actualizarEstado(Integer idLibro, String estado) {
        Libro libro = repositoryLibro.findById(idLibro)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El libro con ID " + idLibro + " no existe."));

        Estado nuevoEstado;
        try {
            nuevoEstado = Estado.valueOf(estado.toUpperCase());
        }  catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El estado '" + estado + "' no es válido. Estados permitidos: DISPONIBLE, PRESTADO, DAÑADO, DESCATALOGADO");
        }
        libro.setEstado(nuevoEstado);

        return modelMapper.map(libro, LibroResponseDTO.class);
    }
}
