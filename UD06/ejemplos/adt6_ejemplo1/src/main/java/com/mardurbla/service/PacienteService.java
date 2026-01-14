package com.mardurbla.service;

import com.mardurbla.model.Paciente;
import com.mardurbla.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository repository;

    public String saludar(Paciente p) {
        return repository.saludar(p);
    }

}
