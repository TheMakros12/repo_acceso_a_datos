package com.example.ejemplo_examen_futbol.repository;

import com.example.ejemplo_examen_futbol.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJugadorRepository extends JpaRepository<Jugador, Integer> {

    List<Jugador> findByEquipo_Id(Integer idEquipo);

}