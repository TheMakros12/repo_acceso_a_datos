package org.example.adt6_practica2.service;

import org.example.adt6_practica2.model.Hotel;

import java.util.List;

public interface IHotelService {

    List<Hotel> listar();
    Hotel listarPorId(Integer id);
    Hotel registrar(Hotel hotel);
    Hotel modificar(Hotel hotel);
    void eliminar(Integer id);

    List<Hotel> listarPorLocalidadYCategoria(String localidad, String categoria);

}
