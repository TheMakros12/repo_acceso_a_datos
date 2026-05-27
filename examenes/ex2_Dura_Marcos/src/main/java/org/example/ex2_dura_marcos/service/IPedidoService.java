package org.example.ex2_dura_marcos.service;

import org.example.ex2_dura_marcos.model.Pedido;
import org.example.ex2_dura_marcos.model.dto.FacturacionResponseDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoResponseDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPedidoService {

    Pedido findByCodigo(String codigo);

    String actualizarEstado(String codigo) throws Exception;

}
