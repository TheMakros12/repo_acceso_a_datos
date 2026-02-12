package org.example.adt6_practica4.repository;

import org.example.adt6_practica4.model.Cliente;
import org.example.adt6_practica4.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    void deleteByClienteEmail(String email);

    List<Reserva> findByClienteEmail(String email);

    List<Reserva> findByConfirmadaTrueAndFechaEntradaAfter(LocalDate fecha);

    long countByConfirmadaTrue();
    long countByConfirmadaFalse();

}
