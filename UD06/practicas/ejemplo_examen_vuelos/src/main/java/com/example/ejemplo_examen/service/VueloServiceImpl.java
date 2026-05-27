package com.example.ejemplo_examen.service;

import com.example.ejemplo_examen.model.EstadoVuelo;
import com.example.ejemplo_examen.model.Vuelo;
import com.example.ejemplo_examen.repository.IVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VueloServiceImpl implements IVueloService {

    @Autowired
    private IVueloRepository repo;

    @Override
    public Vuelo findByCodigo(String codigo) {
        return repo.findByCodigo(codigo);
    }

    @Override
    public String actualizarEstado(String codigo) {
        Vuelo vuelo = repo.findByCodigo(codigo);
        if (vuelo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (vuelo.getEstado() == EstadoVuelo.FINALIZADO) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (vuelo.getEstado() == EstadoVuelo.EN_VUELO) {
            vuelo.setEstado(EstadoVuelo.FINALIZADO);
        }

        if (vuelo.getEstado() == EstadoVuelo.PROGRAMADO) {
            vuelo.setEstado(EstadoVuelo.EN_VUELO);
        }

        repo.save(vuelo);
        return vuelo.getEstado().name();
    }

}
