package org.example.adt6_practica4.repository;

import org.example.adt6_practica4.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findByClienteEmail(String email);

}
