package org.example.adt6_practica2.repository;

import org.example.adt6_practica2.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListResourceBundle;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByLocalidad(String loclidad);
    List<Hotel> findByCategoria(String categoria);
    List<Hotel> findByLocalidadAndCategoria(String localidad, String categoria);

}
