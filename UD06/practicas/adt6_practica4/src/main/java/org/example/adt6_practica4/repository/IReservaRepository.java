package org.example.adt6_practica4.repository;

import org.example.adt6_practica4.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("FROM Reserva r WHERE r.confirmada = :confirmada")
    List<Reserva> listarPorConfirmacion(@Param("confirmada") Boolean confirmada);

    @Modifying
    @Query("DELETE FROM Reserva r WHERE r.cliente.email LIKE %:email%")
    void eliminarReservaPorEmail(@Param("email") String email);

    @Query("FROM Reserva r WHERE r.confirmada = true AND r.fechaEntrada >= :fechaEntrada")
    List <Reserva> listarReservasConfirmadas(@Param("fechaEntrada") LocalDate fechaEntrada);

    @Query("SELECT SUM(r.precioTotal) FROM Reserva r WHERE r.cliente.email = :email")
    int obtenerFacturacion(@Param("email") String email);

}