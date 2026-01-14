package org.example.adt6_ejemplo3.service;

import org.example.adt6_ejemplo3.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductService {

    Product registrar(Product producto);
    Product modificar(Product producto);
    List<Product> listar();
    Product listarPorId(Integer id);
    void eliminar(Integer id);

    List<Product> listarPorCategoria(String categoria);
    List<Product> listarPorFecha(LocalDate fecha1, LocalDate fecha2);

}
