package com.example.ejemplo_examen_soporte.repository;

import com.example.ejemplo_examen_soporte.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

    Ticket findTicketByNombre(String nombre);

}
