package com.example.ejemplo_examen_biblioteca.repository;

import com.example.ejemplo_examen_biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {

    Libro findLibroByIsbn(String isbn);

}
