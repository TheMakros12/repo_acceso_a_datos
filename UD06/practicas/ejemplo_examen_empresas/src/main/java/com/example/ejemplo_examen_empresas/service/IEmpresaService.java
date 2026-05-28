package com.example.ejemplo_examen_empresas.service;

import com.example.ejemplo_examen_empresas.model.dto.EmpresaRequestDTO;
import com.example.ejemplo_examen_empresas.model.dto.EmpresaResponseDTO;

public interface IEmpresaService {

    EmpresaResponseDTO crearEmpresa(EmpresaRequestDTO empresaRequestDTO);

}
