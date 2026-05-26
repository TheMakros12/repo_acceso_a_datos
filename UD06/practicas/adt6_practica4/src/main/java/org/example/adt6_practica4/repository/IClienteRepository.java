package org.example.adt6_practica4.repository;

import org.example.adt6_practica4.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByEmail(String email);

}
