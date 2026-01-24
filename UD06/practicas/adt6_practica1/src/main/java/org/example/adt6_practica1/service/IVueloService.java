package org.example.adt6_practica1.service;

import org.example.adt6_practica1.model.Vuelo;

import java.util.List;

public interface IVueloService {

    List<Vuelo> listar();
    Vuelo registrar(Vuelo vuelo);
    Vuelo modificar(Vuelo vuelo);
    void eliminar(Integer id);
    void eliminarPorDestino(String destino);

    List<Vuelo> buscar(String origen, String destino, Integer numEscalas);
    boolean existsByDestino(String destino);

}
