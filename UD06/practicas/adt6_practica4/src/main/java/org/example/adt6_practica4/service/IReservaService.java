package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;
import org.example.adt6_practica4.model.dto.ResumenDTO;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService {

    Reserva crearReserva(ReservaRequestDTO dto);
    void eliminarReservasPorEmail(String email);
    Integer obtenerFacturacionPorEmail(String email);
    List<ReservaResponseDTO> listarReservasActivasDesde(LocalDate fecha);
    ResumenDTO contarReservasPorEstado();

}
