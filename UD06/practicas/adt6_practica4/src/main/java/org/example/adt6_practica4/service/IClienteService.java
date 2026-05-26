package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Cliente;

public interface IClienteService {

    Cliente findByEmail(String email);

}
