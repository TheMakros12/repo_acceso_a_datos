package com.example.ejemplo_examen_empresas.service;

import com.example.ejemplo_examen_empresas.model.Empleado;
import com.example.ejemplo_examen_empresas.model.Empresa;
import com.example.ejemplo_examen_empresas.model.dto.EmpleadoRequestDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpleadoResponseDTO;
import com.example.ejemplo_examen_empresas.repository.IEmpleadoRepository;
import com.example.ejemplo_examen_empresas.repository.IEmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository repositoryEmpleado;

    @Autowired
    private IEmpresaRepository repositoryEmpresa;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmpleadoResponseDTO contratarEmpleado(Integer idEmpresa, EmpleadoRequestDTO empleadoRequestDTO) {
        Empresa empresa = repositoryEmpresa.findById(idEmpresa)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La empresa con ID " + idEmpresa + " no existe."));

        Empleado empleado = modelMapper.map(empleadoRequestDTO, Empleado.class);
        empleado.setEmpresa(empresa);

        Empleado empleadoContratado = repositoryEmpleado.save(empleado);

        return modelMapper.map(empleadoContratado, EmpleadoResponseDTO.class);
    }

    @Override
    public EmpleadoResponseDTO buscarEmpleadoPorEmail(String email) {
        Empleado empleado = repositoryEmpleado.findEmpleadoByEmail(email);
        if (empleado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EL Empleado con el Email: " + email + " no existe.");
        }

        return modelMapper.map(empleado, EmpleadoResponseDTO.class);
    }

    @Override
    public EmpleadoResponseDTO actualizarEmpleado(Integer idEmpleado, EmpleadoRequestDTO empleadoRequestDTO) {
        Optional<Empleado> empleadoOpt = repositoryEmpleado.findById(idEmpleado);
        if (empleadoOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Empleado con ID: " + idEmpleado + " no existe.");
        }

        Empleado empleado = empleadoOpt.get();
        empleado.setNombreCompleto(empleadoRequestDTO.getNombreCompleto());
        empleado.setPuesto(empleadoRequestDTO.getPuesto());
        empleado.setSalario(empleadoRequestDTO.getSalario());
        empleado.setEmail(empleadoRequestDTO.getEmail());
        empleado.setFechaContratacion(empleadoRequestDTO.getFechaContratacion());

        Empleado empleadoActualizado = repositoryEmpleado.save(empleado);

        return modelMapper.map(empleadoActualizado, EmpleadoResponseDTO.class);
    }

}
