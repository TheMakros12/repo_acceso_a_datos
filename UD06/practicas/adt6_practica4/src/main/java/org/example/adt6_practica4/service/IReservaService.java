package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService {

    List<ReservaResponseDTO> obtenerReservasPorEmail(String email);
    Integer obtenerFacturacionPorEmail(String email);
    Reserva crearReserva(ReservaRequestDTO dto);
    void eliminarReservasPorEmail(String email);

}
