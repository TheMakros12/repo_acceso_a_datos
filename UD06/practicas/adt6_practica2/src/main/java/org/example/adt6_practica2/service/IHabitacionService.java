package org.example.adt6_practica2.service;

import org.example.adt6_practica2.model.Habitacion;

import java.util.List;

public interface IHabitacionService {

    List<Habitacion> listar();
    Habitacion listarPorId(Integer id);
    Habitacion registrar(Habitacion habitacion) throws Exception;
    Habitacion modificar(Habitacion habitacion);
    void eliminar(Integer id);

    Habitacion modificarOcupacion(Integer id);
    List<Habitacion> listarHabitaciones(Integer idHotel);
    List<Habitacion> listarHabitacionesLibres(Integer idHotel);

}
