package com.example.ejemplo_examen_soporte.service;

import com.example.ejemplo_examen_soporte.model.Proyecto;
import com.example.ejemplo_examen_soporte.model.dto.ProyectoRequestDTO;
import com.example.ejemplo_examen_soporte.model.dto.ProyectoResponseDTO;
import com.example.ejemplo_examen_soporte.repository.IProyectoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoServiceImpl implements IProyectoService {

    @Autowired
    private IProyectoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProyectoResponseDTO crearProyecto(ProyectoRequestDTO proyectoRequestDTO) {
        Proyecto proyecto = modelMapper.map(proyectoRequestDTO, Proyecto.class);

        Proyecto proyectoCreado = repository.save(proyecto);

        return modelMapper.map(proyectoCreado, ProyectoResponseDTO.class);
    }

}
