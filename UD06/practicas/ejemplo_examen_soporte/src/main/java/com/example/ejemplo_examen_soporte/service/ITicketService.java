package com.example.ejemplo_examen_soporte.service;

import com.example.ejemplo_examen_soporte.model.dto.TicketRequestDTO;
import com.example.ejemplo_examen_soporte.model.dto.TicketResponseDTO;

public interface ITicketService {

    TicketResponseDTO crearNuevoTicket(Integer idProyecto, TicketRequestDTO ticketRequestDTO);

    TicketResponseDTO buscarTicketPorTitulo(String titulo);

    TicketResponseDTO actualizarEstado(Integer idTicket);

}
