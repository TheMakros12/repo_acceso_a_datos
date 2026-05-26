package com.example.adt6_practica_examen.service;

import com.example.adt6_practica_examen.model.dto.CocheRequestDTO;
import com.example.adt6_practica_examen.model.dto.CocheResponseDTO;
import com.example.adt6_practica_examen.model.Coche;
import com.example.adt6_practica_examen.repository.ICocheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CocheServiceImpl implements ICocheService {

    @Autowired
    private ICocheRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CocheResponseDTO registrar(CocheRequestDTO cocheRequestDTO) throws Exception {
        try {
            if (cocheRequestDTO == null) {
                throw new Exception("El coche no puede ser nulo");
            }

            if (cocheRequestDTO.getMatricula() == null || cocheRequestDTO.getMatricula().isEmpty()) {
                throw new Exception("La matrícula no puede estar vacía");
            }

            Coche coche = modelMapper.map(cocheRequestDTO, Coche.class);
            Coche cocheSaved = repo.save(coche);
            return modelMapper.map(cocheSaved, CocheResponseDTO.class);

        } catch (Exception e) {
            throw new Exception("Error al registrar el coche: " + e.getMessage());
        }
    }

    @Override
    public CocheResponseDTO modificar(CocheRequestDTO cocheRequestDTO) throws Exception {
        try {
            if (cocheRequestDTO == null) {
                throw new Exception("El coche no puede ser nulo");
            }

            if (cocheRequestDTO.getMatricula() == null || cocheRequestDTO.getMatricula().isEmpty()) {
                throw new Exception("La matrícula no puede estar vacía");
            }

            Coche cocheExiste = repo.findById(cocheRequestDTO.getMatricula()).orElse(null);
            if (cocheExiste == null) {
                throw new Exception("No existe un coche con esa matrícula");
            }

            Coche coche = modelMapper.map(cocheRequestDTO, Coche.class);
            Coche cocheUpdated = repo.save(coche);
            return modelMapper.map(cocheUpdated, CocheResponseDTO.class);

        } catch (Exception e) {
            throw new Exception("Error al modificar el coche: " + e.getMessage());
        }
    }

    @Override
    public List<CocheResponseDTO> listar() throws Exception {
        try {
            return repo.findAll().stream()
                    .map(coche -> modelMapper.map(coche, CocheResponseDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error al listar los coches: " + e.getMessage());
        }
    }

    @Override
    public List<CocheResponseDTO> listarPorMarca(String marca) throws Exception {
        try {
            if (marca == null || marca.isEmpty()) {
                throw new Exception("La marca no puede ser vacía.");
            }

            return repo.listarPorMarca(marca).stream()
                    .map(coche -> modelMapper.map(coche, CocheResponseDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error al listar coches por marca: " + e.getMessage());
        }
    }

    @Override
    public CocheResponseDTO findByMatricula(String matricula) throws Exception {
        try {
            if (matricula == null || matricula.isEmpty()) {
                throw new Exception("La matrícula no puede estar vacía.");
            }

            Coche coche = repo.findByMatricula(matricula);
            if (coche == null) {
                throw new Exception("No existe coche con la matrícula: " + matricula);
            }

            return modelMapper.map(coche, CocheResponseDTO.class);
        } catch (Exception e) {
            throw new Exception("Error al buscar coche por matrícula: " + e.getMessage());
        }
    }

    @Override
    public void deleteCocheByMatricula(String matricula) throws Exception {
        try {
            if (matricula == null || matricula.isEmpty()) {
                throw new Exception("La matrícula no puede estar vacía.");
            }

            Coche coche = repo.findByMatricula(matricula);
            if (coche == null) {
                throw new Exception("No existe coche con la matrícula: " + matricula);
            }

            repo.deleteCocheByMatricula(matricula);
        } catch (Exception e) {
            throw new Exception("Error al eliminar el coche: " + e.getMessage());
        }
    }

    @Override
    public List<CocheResponseDTO> findByPrecioRange(Double minPrecio, Double maxPrecio) throws Exception {
        try {
            if (minPrecio == null || maxPrecio == null) {
                throw new Exception("Los precios no pueden ser nulos");
            }
            if (minPrecio > maxPrecio) {
                throw new Exception("El precio mínimo no puede ser mayor que el máximo");
            }

            return repo.findByPrecioRange(minPrecio, maxPrecio).stream()
                    .map(coche -> modelMapper.map(coche, CocheResponseDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error al buscar coches por rango de precio: " + e.getMessage());
        }
    }

    @Override
    public List<CocheResponseDTO> findBajoKilometraje(Integer km) throws Exception {
        try {
            if (km == null || km < 0) {
                throw new Exception("El kilometraje no puede ser nulo o negativo");
            }

            return repo.findBajoKilometraje(km).stream()
                    .map(coche -> modelMapper.map(coche, CocheResponseDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error al buscar coches por bajo kilometraje: " + e.getMessage());
        }
    }

}