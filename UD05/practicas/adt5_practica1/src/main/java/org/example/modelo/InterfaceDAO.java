package org.example.modelo;

import java.util.ArrayList;

public interface InterfaceDAO {
    public int insert(Object obj);
    public int delete(Object obj);
    public ArrayList getAll();
}
