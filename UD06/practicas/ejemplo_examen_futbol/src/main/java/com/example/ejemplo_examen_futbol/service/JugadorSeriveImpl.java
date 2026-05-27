package com.example.ejemplo_examen_futbol.service;

import com.example.ejemplo_examen_futbol.model.Equipo;
import com.example.ejemplo_examen_futbol.model.Jugador;
import com.example.ejemplo_examen_futbol.model.dto.JugadorRequestDTO;
import com.example.ejemplo_examen_futbol.model.dto.JugadorResponseDTO;
import com.example.ejemplo_examen_futbol.repository.IEquipoRepository;
import com.example.ejemplo_examen_futbol.repository.IJugadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorSeriveImpl implements IJugadorService {

    @Autowired
    private IJugadorRepository repositoryJugador;

    @Autowired
    private IEquipoRepository repositoryEquipo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public JugadorResponseDTO ficharJugador(Integer idEquipo, JugadorRequestDTO jugadorRequestDTO) {
        Optional<Equipo> equipoOpt = repositoryEquipo.findById(idEquipo);
        if (equipoOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Equipo con el ID " + idEquipo + " no existe.");
        }
        Equipo equipo = equipoOpt.get();

        Jugador jugador = modelMapper.map(jugadorRequestDTO, Jugador.class);
        jugador.setEquipo(equipo);

        return modelMapper.map(jugador, JugadorResponseDTO.class);
    }

    @Override
    public List<JugadorResponseDTO> obtenerPlantilla(Integer idEquipo) {
        if (!repositoryEquipo.existsById(idEquipo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Equipo con ID " + idEquipo + " no existe.");
        }

        List<Jugador> jugadores = repositoryJugador.findByEquipo_Id(idEquipo);

        return jugadores.stream()
                .map(jugador -> modelMapper.map(jugador, JugadorResponseDTO.class))
                .collect(Collectors.toList());
    }

}
