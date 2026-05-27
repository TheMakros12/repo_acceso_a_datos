package com.example.ejemplo_examen_futbol.repository;

import com.example.ejemplo_examen_futbol.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IEquipoRepository extends JpaRepository<Equipo, Integer> {

    @Query("FROM Equipo e JOIN e.jugadores j GROUP BY e HAVING SUM(j.salario) > :salarioMinimo")
    List<Equipo> listarEquiposPorSalarioMinimo(@Param("salarioMinimo")BigDecimal salarioMinimo);


}