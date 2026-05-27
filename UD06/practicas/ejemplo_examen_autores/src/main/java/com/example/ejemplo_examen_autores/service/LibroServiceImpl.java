package com.example.ejemplo_examen_autores.service;

import com.example.ejemplo_examen_autores.model.Autor;
import com.example.ejemplo_examen_autores.model.GeneroLibro;
import com.example.ejemplo_examen_autores.model.Libro;
import com.example.ejemplo_examen_autores.model.dto.LibroRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.LibroResponseDTO;
import com.example.ejemplo_examen_autores.repository.IAutorRepository;
import com.example.ejemplo_examen_autores.repository.ILibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IAutorRepository autorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LibroResponseDTO anyadirLibroAAutor(Integer idAutor, LibroRequestDTO libroRequestDTO) throws Exception {
        Optional<Autor> autorOpt = autorRepository.findById(idAutor);

        // Si el autor no existe → 404 Not Found
        if (autorOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "El Autor con id " + idAutor + " no existe");
        }
        Autor autor = autorOpt.get();

        // Mapeo LibroRequestDTO → Libro (anioPublicacion → anyoPublicacion configurado en ModelMapperConfig)
        Libro nuevoLibro = modelMapper.map(libroRequestDTO, Libro.class);

        // CORRECCIÓN CRÍTICA: asignar el autor al libro antes de guardarlo.
        // Sin esta línea, el libro se guarda sin 'id_autor' en la base de datos.
        nuevoLibro.setAutor(autor);

        Libro libroGuardado = libroRepository.save(nuevoLibro);

        return modelMapper.map(libroGuardado, LibroResponseDTO.class);
    }

    @Override
    public List<LibroResponseDTO> obtenerLibrosPorAutor(Integer idAutor) throws Exception {
        if (!autorRepository.existsById(idAutor)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "El Autor con id " + idAutor + " no existe");
        }

        List<Libro> libros = libroRepository.findByIdAutor(idAutor);

        return libros.stream()
                .map(libro -> modelMapper.map(libro, LibroResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LibroResponseDTO> buscarLibrosPorGenero(GeneroLibro generoLibro) throws Exception {
        List<Libro> librosPorGenero = libroRepository.findByGenero(generoLibro);

        return librosPorGenero.stream()
                .map(libro -> modelMapper.map(libro, LibroResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LibroResponseDTO> buscarLibrosPorRangoDeAnyos(Integer desde, Integer hasta) throws Exception {
        List<Libro> librosPorRango = libroRepository.findLibrosByRangoDeAnyos(desde, hasta);

        return librosPorRango.stream()
                .map(libro -> modelMapper.map(libro, LibroResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void retirarLibro(Integer idLibro) throws Exception {
        // Si el libro no existe → 404 Not Found
        Libro libro = libroRepository.findById(idLibro)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "El libro con ID " + idLibro + " no existe."));

        libroRepository.delete(libro);
    }

}
