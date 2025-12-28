package org.example;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
