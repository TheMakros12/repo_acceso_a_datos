package com.example.ejemplo_examen_biblioteca.repository;

import com.example.ejemplo_examen_biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBibliotecaRepository extends JpaRepository<Biblioteca, Integer> {


}
