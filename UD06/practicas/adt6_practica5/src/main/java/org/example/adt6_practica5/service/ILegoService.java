package org.example.adt6_practica5.service;

import org.example.adt6_practica5.model.Lego;
import org.example.adt6_practica5.model.dto.PiezasPorCategoriaDTO;
import org.example.adt6_practica5.model.dto.TotalPiezasDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILegoService {

    Lego save(Lego lego);
    Lego update(Lego lego);
    void delete(Integer id);
    List<Lego> findAll();
    List<Lego> findByCategoria(String categoria);
    TotalPiezasDTO getTotalPiezas();
    PiezasPorCategoriaDTO getPiezasPorCategoria(String categoria);

}
