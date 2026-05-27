package com.example.ejemplo_examen_autores.utils;

import com.example.ejemplo_examen_autores.model.Autor;
import com.example.ejemplo_examen_autores.model.Libro;
import com.example.ejemplo_examen_autores.model.dto.AutorResponseDTO;
import com.example.ejemplo_examen_autores.model.dto.LibroRequestDTO;
import com.example.ejemplo_examen_autores.model.dto.LibroResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Autor → AutorResponseDTO:
        // 'idAutor' (Integer) de la entidad no coincide con 'id' (Long) del DTO.
        modelMapper.typeMap(Autor.class, AutorResponseDTO.class).addMappings(mapper ->
                mapper.map(Autor::getIdAutor, AutorResponseDTO::setId)
        );

        // LibroRequestDTO → Libro:
        // 'anioPublicacion' del DTO no coincide con 'anyoPublicacion' de la entidad.
        modelMapper.typeMap(LibroRequestDTO.class, Libro.class).addMappings(mapper ->
                mapper.map(LibroRequestDTO::getAnioPublicacion, Libro::setAnyoPublicacion)
        );

        // Libro → LibroResponseDTO:
        // Varios campos no coinciden, incluidos los campos anidados del autor.
        modelMapper.typeMap(Libro.class, LibroResponseDTO.class).addMappings(mapper -> {
            mapper.map(Libro::getIdLibro, LibroResponseDTO::setId);
            mapper.map(Libro::getAnyoPublicacion, LibroResponseDTO::setAnioPublicacion);
            mapper.map(src -> src.getAutor().getIdAutor(), LibroResponseDTO::setAutorId);
            mapper.map(src -> src.getAutor().getNombre(), LibroResponseDTO::setAutorNombre);
        });

        return modelMapper;
    }

}
