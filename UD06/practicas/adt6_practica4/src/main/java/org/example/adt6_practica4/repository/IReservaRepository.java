package org.example.adt6_practica4.repository;

import org.example.adt6_practica4.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findByClienteEmail(String email);

    List<Reserva> findByConfirmadaTrueAndFechaEntradaAfter(LocalDate fecha);

    @Modifying
    @Query("DELETE FROM Reserva r WHERE r.cliente.email = :email")
    void eliminar(@Param("email") String email);

    @Query("SELECT SUM(r.precioTotal) FROM Reserva r WHERE r.cliente.email = :email ")
    Integer facturacionTotal(@Param("email") String email);

    @Query("FROM Reserva r WHERE r.confirmada = true AND r.fechaEntrada >= :fechaEntrada")
    List<Reserva> listarReservasConfirmadas(@Param("fechaEntrada") LocalDate fechaEntrada);

    @Query("SELECT COUNT(*) FROM Reserva r WHERE r.confirmada = true")
    long seleccionaConfirmadas();

    @Query("SELECT COUNT(*) FROM Reserva r WHERE r.confirmada = false")
    long seleccionaNoConfirmadas();

}
