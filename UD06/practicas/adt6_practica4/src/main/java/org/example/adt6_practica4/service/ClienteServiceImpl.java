package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Cliente;
import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.repository.IClienteRepository;
import org.example.adt6_practica4.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Cliente findByEmail(String email) {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);

        return  cliente.isPresent()? cliente.get() : null;
    }

}
