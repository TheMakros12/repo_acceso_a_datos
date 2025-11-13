package org.example;

import lombok.Data;
import java.util.Date;

@Data
public class Persona {

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;

}