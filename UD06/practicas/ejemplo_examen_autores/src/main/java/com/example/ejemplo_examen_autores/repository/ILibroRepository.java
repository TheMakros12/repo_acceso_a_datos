package com.example.ejemplo_examen_autores.repository;

import com.example.ejemplo_examen_autores.model.GeneroLibro;
import com.example.ejemplo_examen_autores.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {

    // CORRECCIÓN: el campo de la entidad es 'autor' (tipo Autor), no 'idAutor'.
    // Spring Data no puede derivar findByIdAutor → usamos @Query explícita.
    @Query("SELECT l FROM Libro l WHERE l.autor.idAutor = :idAutor")
    List<Libro> findByIdAutor(@Param("idAutor") Integer idAutor);

    List<Libro> findByGenero(GeneroLibro genero);

    @Query("SELECT l FROM Libro l WHERE l.anyoPublicacion BETWEEN :desde AND :hasta ORDER BY l.titulo ASC")
    List<Libro> findLibrosByRangoDeAnyos(@Param("desde") Integer desde, @Param("hasta") Integer hasta);

}
