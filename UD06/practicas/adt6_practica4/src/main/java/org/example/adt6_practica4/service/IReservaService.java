package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Reserva;

import java.util.List;

public interface IReservaService {

    List<Reserva> obtenerReservasPorEmail(String email);

}
