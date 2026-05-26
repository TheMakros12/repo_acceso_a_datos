package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService {

    List<Reserva> listarPorConfirmacion(Boolean confirmada);
    ReservaRequestDTO registrar(ReservaRequestDTO dto) throws Exception;
    void eliminarReservaPorEmail(String email) throws Exception;
    int obtenerFacturacion(String email) throws Exception;
    List<ReservaResponseDTO> listarReservasConfirmadas(LocalDate fechaEntrada);

}
