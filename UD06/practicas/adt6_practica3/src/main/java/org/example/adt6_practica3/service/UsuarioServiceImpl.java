package org.example.adt6_practica3.service;

import org.example.adt6_practica3.model.Usuario;
import org.example.adt6_practica3.model.dto.UsuarioRequestDTO;
import org.example.adt6_practica3.model.dto.UsuarioResponseDTO;
import org.example.adt6_practica3.repository.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioResponseDTO listarPorId(Integer id) {
        Optional<Usuario> usuario = repo.findById(id);
        if (usuario.isPresent()) {
            return modelMapper.map(usuario.get(), UsuarioResponseDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<UsuarioResponseDTO> listar() {
        return repo.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Usuario registrar(UsuarioRequestDTO usuario) {
        Usuario usu = modelMapper.map(usuario, Usuario.class);
        usu.setFechaCreacion(LocalDate.now());

        return repo.save(usu);
    }

    @Override
    public Usuario modificar(Integer id, UsuarioRequestDTO usuario) {
        Optional<Usuario> op = repo.findById(id);

        if (op.isPresent()) {

            Usuario usuMod = op.get();
            usuMod.setNombre(dtoRequest.getNombre());
            usuMod.setApellidos(dtoRequest.getApellidos());
            usuMod.setEmail(dtoRequest.getEmail());
            usuMod.setPassword(dtoRequest.getPassword());

            return repo.save(usuMod);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {

    }
}
