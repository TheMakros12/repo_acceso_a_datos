package com.example.ejemplo_examen_futbol.service;

import com.example.ejemplo_examen_futbol.model.Equipo;
import com.example.ejemplo_examen_futbol.model.dto.EquipoRequestDTO;
import com.example.ejemplo_examen_futbol.model.dto.EquipoResponseDTO;
import com.example.ejemplo_examen_futbol.repository.IEquipoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements IEquipoService{

    @Autowired
    private IEquipoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EquipoResponseDTO registrarEquipo(EquipoRequestDTO equipoRequestDTO) {
        Equipo nuevoEquipo = modelMapper.map(equipoRequestDTO, Equipo.class);

        Equipo equipoGuardado = repository.save(nuevoEquipo);

        return modelMapper.map(equipoGuardado, EquipoResponseDTO.class);
    }

    @Override
    public List<EquipoResponseDTO> buscarEquiposPorSalarioMinimo(BigDecimal salarioMinimo) {
        List<Equipo> equipos = repository.listarEquiposPorSalarioMinimo(salarioMinimo);

        return equipos.stream()
                .map(equipo -> modelMapper.map(equipo, EquipoResponseDTO.class))
                .collect(Collectors.toList());
    }

}
