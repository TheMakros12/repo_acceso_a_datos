package org.example.view;

import javax.swing.*;

public class JFListado extends JFrame {

    public JPanel pnPrincipal;
    public JTable jtUsuarios;
    public JList<String> lUsuarios;

    public JFListado() {
        setContentPane(pnPrincipal);
        setTitle("Listado de Usuarios");
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
