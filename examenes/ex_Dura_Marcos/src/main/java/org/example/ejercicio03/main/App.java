package org.example.ejercicio03.main;


import org.example.ejercicio03.controller.ControladorProducto;
import org.example.ejercicio03.model.ProductoDAO;
import org.example.ejercicio03.view.JFProductos;

public class App {

    public static void main(String[] args) {

        JFProductos vista = new JFProductos();
        ProductoDAO modelo = new ProductoDAO();

        ControladorProducto controladorProducto = new ControladorProducto(vista, modelo);

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

    }
}
