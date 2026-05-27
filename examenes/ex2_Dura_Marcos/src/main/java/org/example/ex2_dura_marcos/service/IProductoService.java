package org.example.ex2_dura_marcos.service;

import org.example.ex2_dura_marcos.model.Producto;
import org.example.ex2_dura_marcos.model.dto.FacturacionResponseDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoRequestDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoResponseDTO;

import java.util.List;

public interface IProductoService {

    List<ProductoResponseDTO> listarProductosCodigo(String codigo) throws Exception;

    Producto agregarProducto(ProductoRequestDTO productoRequestDTO) throws Exception;

    FacturacionResponseDTO obtenerTotal(String codigo) throws Exception;

}
