package org.example.ejemplo_examen_curso.controller;

import jakarta.validation.Valid;
import org.example.ejemplo_examen_curso.model.dto.CursoRequestDTO;
import org.example.ejemplo_examen_curso.model.dto.CursoResponseDTO;
import org.example.ejemplo_examen_curso.model.dto.EstudianteRequestDTO;
import org.example.ejemplo_examen_curso.model.dto.EstudianteResponseDTO;
import org.example.ejemplo_examen_curso.service.ICursoService;
import org.example.ejemplo_examen_curso.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private ICursoService serviceCurso;

    @Autowired
    private IEstudianteService serviceEstudiante;

    @PostMapping("/cursos")
    public ResponseEntity<CursoResponseDTO> crearCurso(@Valid @RequestBody CursoRequestDTO cursoRequestDTO) {
        CursoResponseDTO curso = serviceCurso.crearCurso(cursoRequestDTO);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    @GetMapping("/cursos")
    public ResponseEntity<List<CursoResponseDTO>> listarCursos() {
        List<CursoResponseDTO> cursos = serviceCurso.listarCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @PostMapping("/cursos/{idCurso}/estudiantes")
    public ResponseEntity<EstudianteResponseDTO> matricularEstudiante(@PathVariable Integer idCurso, @Valid @RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        EstudianteResponseDTO estudiante = serviceEstudiante.matricularEstudiante(idCurso, estudianteRequestDTO);
        return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
    }

    @GetMapping("/cursos/{idCurso}/estudiantes")
    public ResponseEntity<List<EstudianteResponseDTO>> listarEstudiantesPorCurso(@PathVariable Integer idCurso) {
        List<EstudianteResponseDTO> estudiantesPorCurso = serviceEstudiante.listarEstudiantes(idCurso);
        return new ResponseEntity<>(estudiantesPorCurso, HttpStatus.OK);
    }

}
