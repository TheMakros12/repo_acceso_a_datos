package org.example.ex2_dura_marcos.controller;

import org.example.ex2_dura_marcos.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PutMapping("/actualizarPedido/{codigo}")
    public ResponseEntity<String> actualizarEstado(@PathVariable String codigo) throws Exception {
        String estado = service.actualizarEstado(codigo);

        return new ResponseEntity<>(estado, HttpStatus.OK);
    }

}
