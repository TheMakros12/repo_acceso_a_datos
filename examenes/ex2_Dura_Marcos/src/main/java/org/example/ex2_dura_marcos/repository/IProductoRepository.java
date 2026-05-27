package org.example.ex2_dura_marcos.repository;

import org.example.ex2_dura_marcos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("FROM Producto p WHERE p.pedido.codigo LIKE :codigo AND p.pedido.estado = 'Entregado'")
    List<Producto> listarProductosCodigo(@Param("codigo") String codigo);

    @Query("SELECT SUM(p.precioUnitario) FROM Producto p WHERE p.pedido.codigo LIKE : codigo")
    Integer obtenerTotal(@Param("codigo") String codigo);

}
