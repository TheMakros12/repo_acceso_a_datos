package com.example.ejemplo_examen_soporte.repository;

import com.example.ejemplo_examen_soporte.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {

}
