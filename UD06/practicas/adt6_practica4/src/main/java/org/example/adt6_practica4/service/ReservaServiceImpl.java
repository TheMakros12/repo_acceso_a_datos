package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepository repo;

    @Override
    public List<Reserva> obtenerReservasPorEmail(String email) {
        return repo.findByClienteEmail(email);
    }

}
