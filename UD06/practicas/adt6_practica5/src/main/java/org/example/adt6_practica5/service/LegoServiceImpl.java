package org.example.adt6_practica5.service;

import org.example.adt6_practica5.model.Lego;
import org.example.adt6_practica5.model.dto.PiezasPorCategoriaDTO;
import org.example.adt6_practica5.model.dto.TotalPiezasDTO;
import org.example.adt6_practica5.repository.ILegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegoServiceImpl implements ILegoService {

    @Autowired
    private ILegoRepository repository;

    @Override
    public Lego save(Lego lego) {
        return repository.save(lego);
    }

    @Override
    public Lego update(Lego lego) {
        return repository.save(lego);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Lego> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Lego> findByCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    @Override
    public TotalPiezasDTO getTotalPiezas() {
        return repository.getToalPiezas();
    }

    @Override
    public PiezasPorCategoriaDTO getPiezasPorCategoria(String categoria) {
        return repository.getToalPiezasPorCategoria(categoria);
    }
}
