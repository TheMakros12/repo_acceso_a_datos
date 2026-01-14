package com.mardurbla.repository;

import com.mardurbla.model.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteRepository {

    public String saludar(Paciente p) {
        return "Hola " + p.getNombre();
    }

}
