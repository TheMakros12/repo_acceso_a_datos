package org.example.ex2_dura_marcos.repository;

import org.example.ex2_dura_marcos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {

    Pedido findByCodigo(String codigo);

}
