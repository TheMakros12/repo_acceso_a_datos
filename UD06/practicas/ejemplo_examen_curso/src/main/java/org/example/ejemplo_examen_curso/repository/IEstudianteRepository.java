package org.example.ejemplo_examen_curso.repository;

import org.example.ejemplo_examen_curso.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

    List<Estudiante> findByCurso_Id(Integer idCurso);

    Estudiante findEstudianteByEmail(String email);

}
