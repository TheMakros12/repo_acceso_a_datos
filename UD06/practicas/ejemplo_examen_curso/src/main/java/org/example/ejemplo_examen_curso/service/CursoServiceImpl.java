package org.example.ejemplo_examen_curso.service;

import org.example.ejemplo_examen_curso.model.Curso;
import org.example.ejemplo_examen_curso.model.dto.CursoRequestDTO;
import org.example.ejemplo_examen_curso.model.dto.CursoResponseDTO;
import org.example.ejemplo_examen_curso.repository.ICursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CursoResponseDTO crearCurso(CursoRequestDTO cursoRequestDTO) {
        Curso nuevoCurso = modelMapper.map(cursoRequestDTO, Curso.class);

        Curso cursoGuardado = repository.save(nuevoCurso);

        return modelMapper.map(cursoGuardado, CursoResponseDTO.class);
    }

    @Override
    public List<CursoResponseDTO> listarCursos() {
        List<Curso> cursos = repository.findAll();

        return cursos.stream()
                .map(curso -> modelMapper.map(curso, CursoResponseDTO.class))
                .collect(Collectors.toList());
    }

}
