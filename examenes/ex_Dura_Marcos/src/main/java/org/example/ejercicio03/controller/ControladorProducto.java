package org.example.ejercicio03.controller;

import org.example.ejercicio03.model.ProductoDAO;
import org.example.ejercicio03.view.JFProductos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorProducto implements ActionListener {

    private JFProductos vista;
    private ProductoDAO modelo;

    public ControladorProducto(JFProductos vistaProducto, ProductoDAO modeloProducto) {
        this.modelo = modeloProducto;
        this.vista = vistaProducto;

        this.vista.btnContar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnContar) {
            String categoria = this.vista.txtContar.getText();
            int totalCategoria = modelo.contar(categoria);
            if (totalCategoria != 0) {
                JOptionPane.showMessageDialog(null, "Total Categoria: " + totalCategoria, "Hay un total de ", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR", "Ha habido un error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == this.vista.btnActualizar) {
            String nombre = this.vista.txtActualizar.getText();
            int totalActualizar = modelo.actualizar(nombre);
            if (totalActualizar != 0) {
                JOptionPane.showMessageDialog(null, "Total Actualizar", "Se ha actualizado el stock", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR", "No se ha podido actualizar porque no existe el producto.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
