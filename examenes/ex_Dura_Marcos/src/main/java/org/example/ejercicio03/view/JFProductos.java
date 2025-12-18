package org.example.ejercicio03.view;

import javax.swing.*;

public class JFProductos extends JFrame {

    public JPanel pnPrincipal;
    private JPanel pnSuperior;
    private JPanel pnCentral;
    private JPanel pnInferior;
    public JTextField txtContar;
    public JButton btnContar;
    public JTextField txtActualizar;
    public JButton btnActualizar;

    public JFProductos() {
        setContentPane(pnPrincipal);
        setTitle("Ex_Dura_Marcos");
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
