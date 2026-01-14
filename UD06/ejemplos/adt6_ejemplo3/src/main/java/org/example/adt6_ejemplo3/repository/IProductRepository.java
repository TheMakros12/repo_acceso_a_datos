package org.example.adt6_ejemplo3.repository;

import org.example.adt6_ejemplo3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query("FROM Product p WHERE LOWER(p.categoria) LIKE %:categoria%")
    List<Product> listarPorCategoria(@Param("categoria") String categoria);

    // >= 03/02/2024 <04/02/2024
    @Query("FROM Product p WHERE p.fechaCreacion BETWEEN :fecha1 AND :fecha2")
    List<Product> listarPorFecha(@Param("fecha1") LocalDate fecha1,
                                 @Param("fecha2") LocalDate fecha2);

}
