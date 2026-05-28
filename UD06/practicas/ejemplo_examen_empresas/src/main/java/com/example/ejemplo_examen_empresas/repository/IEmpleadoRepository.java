package com.example.ejemplo_examen_empresas.repository;

import com.example.ejemplo_examen_empresas.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Empleado findEmpleadoByEmail(String email);

}
