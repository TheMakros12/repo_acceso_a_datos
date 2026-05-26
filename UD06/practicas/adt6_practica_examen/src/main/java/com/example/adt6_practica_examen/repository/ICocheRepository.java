package com.example.adt6_practica_examen.repository;

import com.example.adt6_practica_examen.model.Coche;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICocheRepository extends JpaRepository<Coche, String> {

    @Query("FROM Coche c WHERE LOWER(c.marca) LIKE %:marca%")
    List<Coche> listarPorMarca(@Param("marca") String marca);

    @Query("FROM Coche c WHERE LOWER(c.matricula) = LOWER(:matricula)")
    Coche findByMatricula(@Param("matricula") String matricula);

    @Modifying
    @Transactional
    @Query("DELETE FROM Coche c WHERE LOWER(c.matricula) = LOWER(:matricula)")
    void deleteCocheByMatricula(@Param("matricula") String matricula);

    @Query("FROM Coche c WHERE c.precio BETWEEN :minPrecio AND :maxPrecio")
    List<Coche> findByPrecioRange(@Param("minPrecio") Double minPrecio,
                                  @Param("maxPrecio") Double maxPrecio);

    @Query("FROM Coche c WHERE c.kilometros < :km ORDER BY c.kilometros ASC")
    List<Coche> findBajoKilometraje(@Param("km") Integer km);

}
