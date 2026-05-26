package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Cliente;
import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;
import org.example.adt6_practica4.repository.IReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepository repo;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Reserva> listarPorConfirmacion(Boolean confirmada) {
        return repo.listarPorConfirmacion(confirmada);
    }

    @Override
    public ReservaRequestDTO registrar(ReservaRequestDTO dto) throws Exception {
        Cliente cliente = clienteService.findByEmail(dto.getEmail());
        if ( cliente == null ) {
            throw new Exception("El Cliente no existe.");
        }

        Reserva reserva = modelMapper.map(dto, Reserva.class);
        reserva.setCliente(cliente);
        reserva = repo.save(reserva);

        ReservaRequestDTO resultDto = modelMapper.map(reserva, ReservaRequestDTO.class);
        resultDto.setEmail(cliente.getEmail());
        return resultDto;
    }

    @Override
    @Transactional
    public void eliminarReservaPorEmail(String email) throws Exception {
        Cliente cliente = clienteService.findByEmail(email);

        if ( cliente == null ) {
            throw new Exception("El Cliente no existe.");
        }

        repo.eliminarReservaPorEmail(email);
    }

    @Override
    public int obtenerFacturacion(String email) throws Exception {
        Cliente cliente = clienteService.findByEmail(email);

        if ( cliente == null ) {
            throw new Exception("El Cliente no existe.");
        }

        return repo.obtenerFacturacion(email);
    }

    @Override
    public List<ReservaResponseDTO> listarReservasConfirmadas(LocalDate fechaEntrada) {
        /*List<Reserva> reservas = repo.listarReservasConfirmadas(fechaEntrada);

        List<ReservaResponseDTO> reservasDTO = null;

        for (Reserva r : reservas){
            ReservaResponseDTO reservaDto = modelMapper.map(r, ReservaResponseDTO.class);
            reservasDTO.add(reservaDto);
        }

        return reservasDTO;*/

        List<Reserva> reservas = repo.listarReservasConfirmadas(fechaEntrada);

        List<ReservaResponseDTO> reservasDTO = reservas.stream()
                .map(reserva -> {
                    ReservaResponseDTO dtoRespuesta = modelMapper.map(reserva, ReservaResponseDTO.class);
                    if (reserva.getCliente() != null) {
                        dtoRespuesta.setNombreCliente(reserva.getCliente().getNombre());
                    }
                    return dtoRespuesta;
                })
                .collect(Collectors.toList());

        return reservasDTO;
    }
}
