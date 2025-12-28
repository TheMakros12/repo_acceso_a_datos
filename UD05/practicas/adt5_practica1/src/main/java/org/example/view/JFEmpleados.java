package org.example.view;

import javax.swing.*;

public class JFEmpleados extends JFrame {
    public JPanel pnPrincipal;
    public JPanel pnAbajo;
    public JTable jtEmpleados;
    public JPanel pnIzquierda;
    public JTextField txtDni;
    public JTextField txtNombre;
    public JTextField txtApellidos;
    public JTextField txtEdad;
    public JTextField txtSalario;
    public JPanel pnDerecha;
    public JButton btnInsertar;
    public JButton btnBorrar;
    public JButton btnListar;
    public JPanel pnSuperior;
    public JPanel pnCentral;

    public JFEmpleados() {
        setContentPane(pnPrincipal);
        setTitle("ADT5 - Práctica 1");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
