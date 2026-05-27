package org.example.ex2_dura_marcos.service;

import org.example.ex2_dura_marcos.model.Pedido;
import org.example.ex2_dura_marcos.model.Producto;
import org.example.ex2_dura_marcos.model.dto.FacturacionResponseDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoRequestDTO;
import org.example.ex2_dura_marcos.model.dto.ProductoResponseDTO;
import org.example.ex2_dura_marcos.repository.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoRepository repository;

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoResponseDTO> listarProductosCodigo(String codigo) throws Exception {
        Pedido pedido = pedidoService.findByCodigo(codigo);
        if (pedido == null){
            throw new Exception("El pedido no existe.");
        }

        List<Producto> listaProductos = repository.listarProductosCodigo(codigo);
        if(listaProductos.isEmpty()) {
            throw new Exception("No válido");
        }

        List<ProductoResponseDTO> listaProductosDTO = listaProductos.stream()
                .map(producto -> modelMapper.map(producto, ProductoResponseDTO.class))
                .toList();

        return listaProductosDTO;
    }

    @Override
    public Producto agregarProducto(ProductoRequestDTO productoRequestDTO) throws Exception {
        Pedido pedido = pedidoService.findByCodigo(productoRequestDTO.getCodigoPedido());
        if (pedido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Producto producto = modelMapper.map(productoRequestDTO, Producto.class);
        producto.setPedido(pedido);

        return repository.save(producto);
    }

    @Override
    public FacturacionResponseDTO obtenerTotal(String codigo) throws Exception {
        Pedido pedido = pedidoService.findByCodigo(codigo);

        Integer total = repository.obtenerTotal(codigo);
        if (pedido == null || total == 0) {
            throw new Exception("No válido.");
        }

        FacturacionResponseDTO facturacionDTO = new FacturacionResponseDTO(codigo, pedido.getFecha(), total);

        return facturacionDTO;
    }

}
