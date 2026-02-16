package org.example.adt6_practica5.repository;

import org.example.adt6_practica5.model.Lego;
import org.example.adt6_practica5.model.dto.PiezasPorCategoriaDTO;
import org.example.adt6_practica5.model.dto.TotalPiezasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILegoRepository extends JpaRepository<Lego, Integer> {

    @Query("FROM legos l WHERE LOWER(l.categoria) LIKE %:categoria%")
    public List<Lego> findByCategoria(@Param("categoria") String categoria);

    @Query("SELECT NULLIF(SUM(piezas), 0) FROM legos")
    public TotalPiezasDTO getToalPiezas();

    @Query("SELECT NULLIF(SUM(piezas), 0) AS totalPiezas FROM legos WHERE categoria LIKE %:categoria%")
    public PiezasPorCategoriaDTO getToalPiezasPorCategoria(@Param("categoria") String categoria);

}
