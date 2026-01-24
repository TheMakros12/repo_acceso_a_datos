package org.example.adt6_practica1.service;

import jakarta.transaction.Transactional;
import org.example.adt6_practica1.model.Vuelo;
import org.example.adt6_practica1.repository.IVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VueloServiceImpl implements IVueloService {

    @Autowired
    private IVueloRepository repository;

    @Override
    public List<Vuelo> listar() {
        return repository.findAll();
    }

    @Override
    public Vuelo registrar(Vuelo vuelo) {
        return repository.save(vuelo);
    }

    @Override
    public Vuelo modificar(Vuelo vuelo) {
        return repository.save(vuelo);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void eliminarPorDestino(String destino) {
        repository.eliminarPorDestino(destino);
    }

    @Override
    public boolean existsByDestino(String destino) {
        return repository.esxistePorDestino(destino);
    }

    @Override
    public List<Vuelo> buscar(String origen, String destino, Integer numEscalas) {
        if (origen != null && destino != null && numEscalas != null) {
            return repository.findByOrigenAndDestinoAndNumEscalas(origen, destino, numEscalas);
        } else if (origen != null && destino != null) {
            return repository.findByOrigenAndDestino(origen, destino);
        } else if (origen != null && numEscalas != null) {
            return repository.findByOrigenAndNumEscalas(origen, numEscalas);
        } else if (destino != null && numEscalas != null) {
            return repository.findByDestinoAndNumEscalas(destino, numEscalas);
        } else if (origen != null) {
            return repository.findByOrigen(origen);
        } else if (destino != null) {
            return repository.findByDestino(destino);
        } else if (numEscalas != null) {
            return repository.findByNumEscalas(numEscalas);
        } else {
            return repository.findAll();
        }
    }
}
