package org.example;

import java.io.Serializable;

public class Persona implements Serializable {

    public String nombre;
    public String apellido;
    public Mascota mascota = new Mascota();
    public int edad;

    public Persona(int i) {
        setPersona(i);
    }

    public void setPersona(int i) {
        this.nombre = "Nombre " + i;
        this.apellido = "Apellido " + i;
        this.mascota.nombre = "Fido" + i;
        this.edad = i;
    }

}
