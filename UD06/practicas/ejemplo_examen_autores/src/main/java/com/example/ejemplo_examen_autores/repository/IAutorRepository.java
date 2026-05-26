package com.example.ejemplo_examen_autores.repository;

import com.example.ejemplo_examen_autores.model.Autor;
import com.example.ejemplo_examen_autores.model.GeneroLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer> {

    @Query("SELECT DISTINCT a FROM Autor a JOIN a.libros l WHERE l.genero = :genero")
    List<Autor> findAutoresByGenero(@Param("genero") GeneroLibro genero);

}
