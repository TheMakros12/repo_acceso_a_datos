package com.example.ejemplo_examen_soporte.service;

import com.example.ejemplo_examen_soporte.model.Estado;
import com.example.ejemplo_examen_soporte.model.Proyecto;
import com.example.ejemplo_examen_soporte.model.Ticket;
import com.example.ejemplo_examen_soporte.model.dto.TicketRequestDTO;
import com.example.ejemplo_examen_soporte.model.dto.TicketResponseDTO;
import com.example.ejemplo_examen_soporte.repository.IProyectoRepository;
import com.example.ejemplo_examen_soporte.repository.ITicketRepository;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private ITicketRepository repositoryTicket;

    @Autowired
    private IProyectoRepository repositoryProyecto;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TicketResponseDTO crearNuevoTicket(Integer idProyecto, TicketRequestDTO ticketRequestDTO) {
        Proyecto proyecto = repositoryProyecto.findById(idProyecto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El Proyecto con ID " + idProyecto + " no existe."));

        Ticket ticket = modelMapper.map(ticketRequestDTO, Ticket.class);
        ticket.setProyecto(proyecto);

        Ticket ticketCreado = repositoryTicket.save(ticket);

        return modelMapper.map(ticketCreado, TicketResponseDTO.class);
    }

    @Override
    public TicketResponseDTO buscarTicketPorTitulo(String titulo) {
        Ticket ticket = repositoryTicket.findTicketByNombre(titulo);
        if (ticket == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Ticket con el Nombre " + titulo + " no existe.");
        }

        return modelMapper.map(ticket, TicketResponseDTO.class);
    }

    @Override
    public TicketResponseDTO actualizarEstado(Integer idTicket) {
        Ticket ticket = repositoryTicket.findById(idTicket)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El Ticket con ID " + idTicket + " no existe."));

        if (ticket.getEstado() == Estado.CERRADO) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El Ticket con el ID " + idTicket + " ya está cerrado.");
        }

        if (ticket.getEstado() == Estado.ABIERTO) {
            ticket.setEstado(Estado.EN_PROGRESO);
        }

        if (ticket.getEstado() == Estado.EN_PROGRESO) {
            ticket.setEstado(Estado.CERRADO);
        }

        Ticket ticketModificado = repositoryTicket.save(ticket);

        return modelMapper.map(ticketModificado, TicketResponseDTO.class);
    }

}
