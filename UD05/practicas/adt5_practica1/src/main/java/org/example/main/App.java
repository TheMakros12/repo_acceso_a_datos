package org.example.main;

import org.example.controller.ControladorEmpleado;
import org.example.model.EmpleadoDAO;
import org.example.view.JFEmpleados;

public class App {

    public static void main(String[] args) {

        JFEmpleados vista = new JFEmpleados();
        EmpleadoDAO modelo = new EmpleadoDAO();

        ControladorEmpleado ce = new ControladorEmpleado(vista, modelo);

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);


    }

}