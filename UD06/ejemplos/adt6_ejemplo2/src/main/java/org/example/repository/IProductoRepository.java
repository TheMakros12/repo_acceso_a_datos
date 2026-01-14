package org.example.repository;

import org.example.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("FROM Producto p WHERE LOWER(p.categoria) LIKE %:categoria%")
    List<Producto> buscarPorCategoria(@Param("categoria") String categoria);

    @Query("FROM Producto p WHERE p.fechaCreacion BETWEEN :fecha1 AND :fecha2")
    List<Producto> listarPorFecha(@Param("fecha1")LocalDate fecha1,
                                  @Param("fecha2") LocalDate fecha2);

}
