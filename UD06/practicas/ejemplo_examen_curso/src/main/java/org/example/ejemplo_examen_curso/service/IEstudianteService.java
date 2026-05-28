package org.example.ejemplo_examen_curso.service;

import org.example.ejemplo_examen_curso.model.dto.EstudianteRequestDTO;
import org.example.ejemplo_examen_curso.model.dto.EstudianteResponseDTO;

import java.util.List;

public interface IEstudianteService {

    EstudianteResponseDTO matricularEstudiante(Integer idCurso, EstudianteRequestDTO estudianteRequestDTO);

    List<EstudianteResponseDTO> listarEstudiantes(Integer idCurso);

    EstudianteResponseDTO buscarPorEmail(String email);

    EstudianteResponseDTO actualizarEstudiante(Integer idEstudiante, EstudianteRequestDTO estudianteRequestDTO);

    void eliminarEstudiante(Integer idEstudiante);

}
