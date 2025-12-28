package org.example.model;

import java.util.List;

public interface InterfaceDAO<T> {
    int insert(T obj);
    int delete(T obj);
    List<T> getAll();
}
