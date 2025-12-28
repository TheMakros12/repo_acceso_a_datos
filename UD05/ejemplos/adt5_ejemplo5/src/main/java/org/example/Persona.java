package org.example;

import jakarta.persistence.*;

@Entity
public class Persona {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column
    private String nombre;

   @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
   @JoinColumn(name = "id_direccion")
   private Direccion direccion;

    public Persona() {
    }

    public Persona(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                '}';
    }

}
