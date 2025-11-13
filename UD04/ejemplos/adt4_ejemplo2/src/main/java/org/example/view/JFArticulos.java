package org.example.view;

import javax.swing.*;

public class JFArticulos extends JFrame{

    public JPanel pnlPrincipal;
    private JPanel pnlSuperior;
    private JPanel pnlCentral;
    private JPanel pnlInferior;
    private JPanel pnlIzquierda;
    private JPanel pblDerecha;
    public JTextField txtId;
    public JTextField txtPrecio;
    public JTextField txtStock;
    public JTextField txtNombre;
    public JTextField txtDescripcion;
    public JButton btnNuevo;
    public JButton btnGuardar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnSeleccionar;
    public JTextField txtBusquedaNombre;
    public JTextField txtTotalArticulos;
    public JTable jtArticulos;
    public JTextField txtImagen;

    public JFArticulos(){
        setContentPane(pnlPrincipal);
        setTitle("ADT4_Ejemplo2");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
