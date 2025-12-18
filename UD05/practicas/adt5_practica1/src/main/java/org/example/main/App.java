package org.example.main;

import org.example.controlador.ControladorEmpleado;
import org.example.modelo.EmpleadoDAO;
import org.example.vista.JFEmpleados;

public class App {

    public static void main(String[] args) {

        JFEmpleados vista = new JFEmpleados();
        EmpleadoDAO modelo = new EmpleadoDAO();

        ControladorEmpleado ce = new ControladorEmpleado(vista, modelo);

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

}