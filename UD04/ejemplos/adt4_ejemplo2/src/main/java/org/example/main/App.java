package org.example.main;

import org.example.controller.ControladorArticulo;
import org.example.model.ArticuloDAO;
import org.example.view.JFArticulos;

public class App {

    public static void main(String[] args) {

        JFArticulos vista = new JFArticulos();
        ArticuloDAO modelo = new ArticuloDAO();

        ControladorArticulo ca = new ControladorArticulo(vista, modelo);

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

}