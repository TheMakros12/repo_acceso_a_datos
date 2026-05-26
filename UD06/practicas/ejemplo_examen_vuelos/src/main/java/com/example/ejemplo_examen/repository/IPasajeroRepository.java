package com.example.ejemplo_examen.repository;

import com.example.ejemplo_examen.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IPasajeroRepository extends JpaRepository<Pasajero, Integer> {

    @Query("FROM Pasajero p WHERE p.vuelo.codigo LIKE :codigo AND p.vuelo.estado = 'Finalizado'")
    List<Pasajero> listarPasajerosCodigo(@Param("codigo") String codigo);

    @Query("SELECT SUM(p.precioBillete) FROM Pasajero p WHERE p.vuelo.codigo LIKE :codigo")
    BigDecimal obtenerTotal(@Param("codigo") String codigo);

}
