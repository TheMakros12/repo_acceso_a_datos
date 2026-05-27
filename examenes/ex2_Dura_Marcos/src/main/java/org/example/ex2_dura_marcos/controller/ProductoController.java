package org.example.ex2_dura_marcos.controller;

import jakarta.validation.Valid;
import org.example.ex2_dura_marcos.model.Pedido;
import org.example.ex2_dura_marcos.model.Producto;
import org.example.ex2_dura_marcos.model.dto.FacturacionResponseDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoRequestDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoResponseDTO;
import org.example.ex2_dura_marcos.service.IPedidoService;
import org.example.ex2_dura_marcos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping("/listarProductos/{codigo}")
    public ResponseEntity<List<ProductoResponseDTO>> listarProductosCodigo(@PathVariable String codigo) {
        try {
            List<ProductoResponseDTO> productos = service.listarProductosCodigo(codigo);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/agregarProducto")
    public ResponseEntity<Producto> agregarProducto(@Valid @RequestBody ProductoRequestDTO productoRequestDTO) {
        try {
            Producto producto = service.agregarProducto(productoRequestDTO);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("obtenerTotal/{codigo}")
    public ResponseEntity<FacturacionResponseDTO> obtenerTotal(@PathVariable String codigo) {
        try {
            FacturacionResponseDTO dto = service.obtenerTotal(codigo);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
