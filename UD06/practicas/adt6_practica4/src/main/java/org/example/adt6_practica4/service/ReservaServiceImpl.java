package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Cliente;
import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;
import org.example.adt6_practica4.model.dto.ResumenDTO;
import org.example.adt6_practica4.repository.IClienteRepository;
import org.example.adt6_practica4.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Reserva crearReserva(ReservaRequestDTO dto) {
        if (!dto.getFechaSalida().isAfter(dto.getFechaEntrada())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La fecha de salida debe ser posterior a la fecha de entrada"
            );
        }

        Cliente cliente = clienteRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "El email no existe"
                ));

        Reserva reserva = new Reserva();
        reserva.setFechaEntrada(dto.getFechaEntrada());
        reserva.setFechaSalida(dto.getFechaSalida());
        reserva.setPrecioTotal(dto.getPrecioTotal());
        reserva.setConfirmada(false); // por defecto
        reserva.setCliente(cliente);

        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReservasPorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente no encontrado"
                ));

        List<Reserva> reservas = reservaRepository.findByClienteEmail(email);
        reservaRepository.deleteAll(reservas);
    }

    @Override
    public Integer obtenerFacturacionPorEmail(String email) {
        if ( !clienteRepository.existsByEmail(email) ) {
            return null;
        }

        List<Reserva> reservas = reservaRepository.findByClienteEmail(email);
        int total = reservas.stream()
                .mapToInt(Reserva::getPrecioTotal)
                .sum();

        if ( total == 0 ) {
            return null;
        }

        return total;
    }

    @Override
    public List<ReservaResponseDTO> listarReservasActivasDesde(LocalDate fecha) {
        return reservaRepository
                .findByConfirmadaTrueAndFechaEntradaAfter(fecha)
                .stream()
                .map(r -> new ReservaResponseDTO(
                        r.getCliente().getNombre(),
                        r.getFechaEntrada(),
                        r.getPrecioTotal()
                ))
                .toList();
    }

    @Override
    public ResumenDTO contarReservasPorEstado() {
        List<Reserva> reservas = reservaRepository.findAll();

        long confirmadas = reservas.stream()
                .filter(Reserva::isConfirmada)
                .count();

        long noConfirmadas = reservas.stream()
                .filter(r -> !r.isConfirmada())
                .count();

        return new ResumenDTO(confirmadas, noConfirmadas);
    }

}
