package com.example.ejemplo_examen.repository;

import com.example.ejemplo_examen.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, Integer> {

    Vuelo findByCodigo(String codigo);

}
