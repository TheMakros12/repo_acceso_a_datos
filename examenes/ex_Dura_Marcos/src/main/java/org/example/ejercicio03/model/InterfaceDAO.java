package org.example.ejercicio03.model;

public interface InterfaceDAO<T> {

    int contar(String categoria);
    int actualizar(String nombre);

}
