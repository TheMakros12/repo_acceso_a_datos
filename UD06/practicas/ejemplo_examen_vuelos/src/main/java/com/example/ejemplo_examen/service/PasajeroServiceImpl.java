package com.example.ejemplo_examen.service;

import com.example.ejemplo_examen.model.Pasajero;
import com.example.ejemplo_examen.model.Vuelo;
import com.example.ejemplo_examen.model.dto.PasajeroRequestDTO;
import com.example.ejemplo_examen.model.dto.PasajeroResponseDTO;
import com.example.ejemplo_examen.model.dto.RecaudacionResponseDTO;
import com.example.ejemplo_examen.repository.IPasajeroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PasajeroServiceImpl implements IPasajeroService {

    @Autowired
    private IPasajeroRepository repo;

    @Autowired
    private IVueloService vueloService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PasajeroResponseDTO> listarPasajerosCodigo(String codifo) {
        Vuelo vuelo = vueloService.findByCodigo(codifo);
        if (vuelo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El vuelo no existe");
        }

        List<Pasajero> listaPasajeros = repo.listarPasajerosCodigo(codifo);
        if (listaPasajeros.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No válido");
        }

        List<PasajeroResponseDTO> listaPasajerosDTO = listaPasajeros.stream()
                .map(pasajero -> modelMapper.map(pasajero, PasajeroResponseDTO.class))
                .toList();

        return listaPasajerosDTO;
    }

    @Override
    public Pasajero agregarPasajero(PasajeroRequestDTO pasajeroRequestDTO) {
        Vuelo vuelo = vueloService.findByCodigo(pasajeroRequestDTO.getCodigoVuelo());
        if (vuelo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Pasajero pasajero = modelMapper.map(pasajeroRequestDTO, Pasajero.class);
        pasajero.setVuelo(vuelo);

        return repo.save(pasajero);
    }

    @Override
    public RecaudacionResponseDTO obtenerTotal(String codigo) {
        Vuelo vuelo = vueloService.findByCodigo(codigo);

        BigDecimal total = repo.obtenerTotal(codigo);
        if (vuelo == null || total == null || total.signum() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No válido");
        }

        RecaudacionResponseDTO recaudacionDTO = new RecaudacionResponseDTO(codigo, vuelo.getFecha(), total);
        return recaudacionDTO;
    }

}
