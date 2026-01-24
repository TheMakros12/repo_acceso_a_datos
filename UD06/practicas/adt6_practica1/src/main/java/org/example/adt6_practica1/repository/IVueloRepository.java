package org.example.adt6_practica1.repository;

import org.example.adt6_practica1.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, Integer> {

    @Modifying
    @Query(value = "DELETE FROM vuelo WHERE destino LIKE %:destino%", nativeQuery = true)
    void eliminarPorDestino(@Param("destino") String destino);

    List<Vuelo> findByOrigenAndDestinoAndNumEscalas(String origen, String destino, Integer numeroEscalas);
    List<Vuelo> findByOrigenAndDestino(String origen, String destino);
    List<Vuelo> findByOrigenAndNumEscalas(String origen, Integer numeroEscalas);
    List<Vuelo> findByDestinoAndNumEscalas(String destino, Integer numeroEscalas);
    List<Vuelo> findByOrigen(String origen);
    List<Vuelo> findByDestino(String destino);
    List<Vuelo> findByNumEscalas(Integer numeroEscalas);

    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN 'true' ELSE 'false' END FROM vuelo v WHERE v.destino = :destino")
    boolean esxistePorDestino(@Param("destino") String destino);

}
