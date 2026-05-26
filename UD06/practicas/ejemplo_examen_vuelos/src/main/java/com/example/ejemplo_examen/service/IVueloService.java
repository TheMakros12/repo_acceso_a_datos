package com.example.ejemplo_examen.service;

import com.example.ejemplo_examen.model.Vuelo;

public interface IVueloService {

    Vuelo findByCodigo(String codigo);

    String actualizarEstado(String codigo) throws Exception;

}
