package com.example.ejemplo_examen_empresas.service;

import com.example.ejemplo_examen_empresas.model.Empresa;
import com.example.ejemplo_examen_empresas.model.dto.EmpresaRequestDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpresaResponseDTO;
import com.example.ejemplo_examen_empresas.repository.IEmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmpresaResponseDTO crearEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = modelMapper.map(empresaRequestDTO, Empresa.class);

        Empresa empresaGuardada = repository.save(empresa);

        return modelMapper.map(empresaGuardada, EmpresaResponseDTO.class);
    }

}
