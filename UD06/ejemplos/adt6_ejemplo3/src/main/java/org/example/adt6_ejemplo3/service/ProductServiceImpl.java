package org.example.adt6_ejemplo3.service;

import org.example.adt6_ejemplo3.model.Product;
import org.example.adt6_ejemplo3.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repo;

    @Override
    public Product registrar(Product producto) {
        return repo.save(producto);
    }

    @Override
    public Product modificar(Product producto) {
        return repo.save(producto);
    }

    @Override
    public List<Product> listar() {
        return repo.findAll();
    }

    @Override
    public Product listarPorId(Integer id) {
        Optional<Product> producto = repo.findById(id);
        return producto.isPresent() ? producto.get() : new Product();
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Product> listarPorCategoria(String categoria) {
        return repo.listarPorCategoria(categoria);
    }

    @Override
    public List<Product> listarPorFecha(LocalDate fecha1, LocalDate fecha2) {
        return repo.listarPorFecha(fecha1, fecha2);
    }
}
