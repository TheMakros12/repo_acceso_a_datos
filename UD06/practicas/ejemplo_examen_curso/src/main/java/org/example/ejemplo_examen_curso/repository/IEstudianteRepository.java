package org.example.ejemplo_examen_curso.repository;

import org.example.ejemplo_examen_curso.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

    Estudiante findEstudianteByEmail(String email);

}
