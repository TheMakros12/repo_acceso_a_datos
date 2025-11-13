package org.example.view;

import javax.swing.*;

public class JFEmpleados extends JFrame {

    public JPanel panelPrincipal;
    private JPanel panelSuperior;
    private JPanel panelCentral;
    private JPanel panelInferior;
    private JPanel panelIzquierda;
    private JPanel panelDerecha;
    public JTextField txtDni;
    public JButton btnInsert;
    public JButton btnDelete;
    public JButton btnList;
    public JTextField txtName;
    public JTextField txtLastName;
    public JTextField txtYears;
    public JTextField txtSalary;

    public JFEmpleados() {
        setContentPane(panelPrincipal);
        setTitle("ADT4_Práctica1");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
