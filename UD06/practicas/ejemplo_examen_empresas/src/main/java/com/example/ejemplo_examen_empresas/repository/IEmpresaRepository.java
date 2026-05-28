package com.example.ejemplo_examen_empresas.repository;

import com.example.ejemplo_examen_empresas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {


}
