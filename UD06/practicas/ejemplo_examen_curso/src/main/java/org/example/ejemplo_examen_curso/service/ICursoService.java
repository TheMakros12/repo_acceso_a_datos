package org.example.ejemplo_examen_curso.service;

import org.example.ejemplo_examen_curso.model.dto.CursoRequestDTO;
import org.example.ejemplo_examen_curso.model.dto.CursoResponseDTO;

import java.util.List;

public interface ICursoService {

    CursoResponseDTO crearCurso(CursoRequestDTO cursoRequestDTO);

    List<CursoResponseDTO> listarCursos();

}
