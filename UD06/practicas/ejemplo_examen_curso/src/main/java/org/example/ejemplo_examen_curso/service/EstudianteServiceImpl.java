package org.example.ejemplo_examen_curso.service;

import org.example.ejemplo_examen_curso.model.Curso;
import org.example.ejemplo_examen_curso.model.Estudiante;
import org.example.ejemplo_examen_curso.model.dto.EstudianteRequestDTO;
import org.example.ejemplo_examen_curso.model.dto.EstudianteResponseDTO;
import org.example.ejemplo_examen_curso.repository.ICursoRepository;
import org.example.ejemplo_examen_curso.repository.IEstudianteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository repositoryEstudiante;

    @Autowired
    private ICursoRepository repositoryCurso;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EstudianteResponseDTO matricularEstudiante(Integer idCurso, EstudianteRequestDTO estudianteRequestDTO) {
        Optional<Curso> cursoOpt = repositoryCurso.findById(idCurso);
        if (cursoOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Curso con ID " + idCurso + " no existe.");
        }
        Curso curso = cursoOpt.get();

        Estudiante estudiante = modelMapper.map(estudianteRequestDTO, Estudiante.class);
        estudiante.setCurso(curso);

        Estudiante nuevoEstudiante = repositoryEstudiante.save(estudiante);

        return modelMapper.map(nuevoEstudiante, EstudianteResponseDTO.class);
    }

    @Override
    public List<EstudianteResponseDTO> listarEstudiantes(Integer idCurso) {
        if(!repositoryCurso.existsById(idCurso)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Curso con ID " + idCurso + " no existe.");
        }

        List<Estudiante> estudiantes = repositoryEstudiante.findByCurso_Id(idCurso);

        return estudiantes.stream()
                .map(estudiante -> modelMapper.map(estudiante, EstudianteResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteResponseDTO buscarPorEmail(String email) {
        Estudiante estudiante = repositoryEstudiante.findEstudianteByEmail(email);
        if (estudiante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Estudiante con el email: " + email + " no existe.");
        }

        return modelMapper.map(estudiante, EstudianteResponseDTO.class);
    }

    @Override
    public EstudianteResponseDTO actualizarEstudiante(Integer idEstudiante, EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = repositoryEstudiante.findById(idEstudiante)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El estudiante con ID " + idEstudiante + " no existe."));

        estudiante.setNombreCompleto(estudianteRequestDTO.getNombreCompleto());
        estudiante.setEmail(estudianteRequestDTO.getEmail());
        estudiante.setFechaMatriculacion(estudianteRequestDTO.getFechaMatriculacion());

        Estudiante estudianteActualizado = repositoryEstudiante.save(estudiante);

        return modelMapper.map(estudianteActualizado, EstudianteResponseDTO.class);
    }

    @Override
    public void eliminarEstudiante(Integer idEstudiante) {
        Estudiante estudiante = repositoryEstudiante.findById(idEstudiante)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El estudiante con ID " + idEstudiante + " no existe."));

        repositoryEstudiante.delete(estudiante);
    }

}
