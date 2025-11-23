package org.example.view;

import org.example.model.User;

import javax.swing.*;

public class JFListado extends JFrame {

    public JPanel pnPrincipal;
    public JTable jtUsuarios;
    public JList<User> lUsuarios;

    public JFListado() {
        setContentPane(pnPrincipal);
        setTitle("Listado de Usuarios");
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
