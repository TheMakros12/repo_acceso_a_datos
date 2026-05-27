package org.example.ex2_dura_marcos.service;

import org.example.ex2_dura_marcos.model.Pedido;
import org.example.ex2_dura_marcos.model.Producto;
import org.example.ex2_dura_marcos.model.dto.FacturacionResponseDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoRequestDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoResponseDTO;
import org.example.ex2_dura_marcos.repository.IPedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public Pedido findByCodigo(String codigo) {
        return pedidoRepository.findByCodigo(codigo);
    }

    @Override
    public String actualizarEstado(String codigo) throws Exception {
        Pedido pedido = pedidoRepository.findByCodigo(codigo);

        if (pedido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (pedido.getEstado().equalsIgnoreCase("Entregado")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (pedido.getEstado().equalsIgnoreCase("Enviado")) {
            pedido.setEstado("Entregado");
        }

        if (pedido.getEstado().equalsIgnoreCase("Pendiente")) {
            pedido.setEstado("Enviado");
        }

        pedidoRepository.save(pedido);

        return pedido.getEstado();
    }

}
