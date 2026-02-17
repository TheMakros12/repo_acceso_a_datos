package org.example.adt6_practica4.service;

import org.example.adt6_practica4.model.Cliente;
import org.example.adt6_practica4.model.Reserva;
import org.example.adt6_practica4.model.dto.ReservaRequestDTO;
import org.example.adt6_practica4.model.dto.ReservaResponseDTO;
import org.example.adt6_practica4.model.dto.ResumenDTO;
import org.example.adt6_practica4.repository.IReservaRepository;
import org.example.adt6_practica4.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Reserva crearReserva(ReservaRequestDTO dto) throws Exception {
        Cliente cliente = clienteService.findByEmail(dto.getEmail());

        if (cliente == null) {
            throw new Exception("El Cliente no existe");
        }

        if (dto.getFechaEntrada().isAfter(dto.getFechaSalida())) {
            throw new Exception("La fecha de entrada NO puede ser posterior a la fecha de salida!!!");
        }

        Reserva reserva = modelMapper.modelMapper().map(dto, Reserva.class);

        reserva.setConfirmada(false);
        reserva.setCliente(cliente);

        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReservasPorEmail(String email) {
        Cliente cliente = clienteService.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente no encontrado"
                ));

        List<Reserva> reservas = reservaRepository.findByClienteEmail(email);
        reservaRepository.deleteAll(reservas);
    }

    @Override
    public Integer obtenerFacturacionPorEmail(String email) {
        if ( !clienteService.existsByEmail(email) ) {
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
                .map(reserva -> modelMapper.modelMapper().map(reserva, ReservaResponseDTO.class))
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

    @Transactional
    @Override
    public void eliminar(String email) throws Exception {
        Cliente cliente = clienteService.findByEmail(email);
        if (cliente == null) {
            throw new Exception("El Cliente no existe");
        }

        reservaRepository.eliminar(email);
    }

    @Override
    public Integer facturacionTotal(String email) throws Exception {
        Cliente cliente = clienteService.findByEmail(email);
        if (cliente == null) {
            throw new Exception("El Cliente no existe");
        }

       return reservaRepository.facturacionTotal(email);
    }

    @Override
    public List<ReservaResponseDTO> seleccionaConfirmadas(LocalDate fecha) {

        /*List<Reserva> lista = repo.seleccionaConfFecha(fechaEntrada);

        List<ReservaResponseDTO> listadoDTO = lista.stream()
                .map(res -> modelMapper.map(res, ReservaResponseDTO.class))
                .collect(Collectors.toList());

        return listadoDTO; */

        List<Reserva> lista = reservaRepository.listarReservasConfirmadas(fecha);

        List<ReservaResponseDTO> lsitaFinal = new ArrayList<>();

        for (Reserva r : lista) {
            ReservaResponseDTO reserva = modelMapper.modelMapper().map(r, ReservaResponseDTO.class);
            lsitaFinal.add(reserva);
        }

        return lsitaFinal;
    }

    @Override
    public ResumenDTO confirmadasNoConfirmadas() {
        ResumenDTO dto = new ResumenDTO();
        dto.setConfirmadas(reservaRepository.seleccionaConfirmadas());
        dto.setNoConfirmadas(reservaRepository.seleccionaNoConfirmadas());

        return dto;
    }
}
