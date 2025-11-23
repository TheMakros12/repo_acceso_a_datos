package org.example.controller;

import org.example.model.User;
import org.example.model.UserDAO;
import org.example.view.JFListado;
import org.example.view.JFLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener {

    JFLogin vista;
    UserDAO modelo;

    public ControladorLogin(JFLogin vistaLogin, UserDAO modeloLogin) {
        this.vista = vistaLogin;
        this.modelo = modeloLogin;

        this.vista.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnLogin) {
            String username = vista.txtUsername.getText();
            String password = vista.txtPassword.getText();

            User userLogin = modelo.login(username, password);
            if (userLogin != null) {
                JOptionPane.showMessageDialog(null, "Usuario logueado correctamente.", "Login Correcto", JOptionPane.INFORMATION_MESSAGE);
                JFListado vistaListado = new JFListado();
                ControladorListado ctrlListado = new ControladorListado(vistaListado, modelo);
                vistaListado.setLocationRelativeTo(null);
                vistaListado.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!! Usuario incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
