package org.example.service;

import org.example.model.Producto;
import org.example.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository repository;

    @Override
    public Producto registrar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto modificar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Producto listarPorId(Integer id) {
        Optional<Producto> op = repository.findById(id);
        return op.isPresent()? op.get() : null;
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producto> listarPorCategoria(String categoria) {
        return repository.buscarPorCategoria(categoria);
    }

    @Override
    public List<Producto> listarPorFecha(LocalDate fecha1, LocalDate fecha2) {
        return repository.listarPorFecha(fecha1, fecha2);
    }
}
