package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Cliente;
import org.example.adt6_practica4.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository repo;

    @Override
    public Cliente findByEmail(String email) {
        Cliente cliente = repo.findByEmail(email);
        return cliente;
    }

}
