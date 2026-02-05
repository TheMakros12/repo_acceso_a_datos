package org.example.adt6_practica3.service;

import jakarta.validation.Valid;
import org.example.adt6_practica3.model.Usuario;
import org.example.adt6_practica3.model.dto.UsuarioRequestDTO;
import org.example.adt6_practica3.model.dto.UsuarioResponseDTO;

import java.util.List;

public interface IUsuarioService {

    UsuarioResponseDTO listarPorId(Integer id);
    List<UsuarioResponseDTO> listar();
    Usuario registrar(@Valid UsuarioRequestDTO usuario);
    Usuario modificar(Integer id, UsuarioRequestDTO usuario);
    void eliminar(Integer id);

}
