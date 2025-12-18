package org.example.vista;

import javax.swing.*;

public class JFEmpleados extends JFrame {
    public JPanel pnPrincipal;
    private JPanel pnIzquierda;
    private JPanel pnDerecha;
    private JPanel pnAbajo;
    public JTextField txtDni;
    public JTextField txtNombre;
    public JTextField txtApellidos;
    public JTextField txtEdad;
    public JTextField txtSalario;
    public JButton btnInsertar;
    public JButton btnBorrar;
    public JButton btnListar;
    public JTable jtEmpleados;

    public JFEmpleados() {
        setContentPane(pnPrincipal);
        setTitle("ADT5 - Práctica 1");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
