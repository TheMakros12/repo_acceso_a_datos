package org.example.main;

import org.example.controller.ControladorLogin;
import org.example.model.UserDAO;
import org.example.view.JFLogin;

public class App {

    public static void main(String[] args) {

        JFLogin vista = new JFLogin();
        UserDAO modelo = new UserDAO();

        ControladorLogin cl = new ControladorLogin(vista, modelo);

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

}