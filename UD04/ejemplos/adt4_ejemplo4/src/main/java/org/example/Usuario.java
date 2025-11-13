package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private @Setter int id;
    private @Getter String nombre;
    private String apellidos;
    private String correo;
    private boolean activa;

}
