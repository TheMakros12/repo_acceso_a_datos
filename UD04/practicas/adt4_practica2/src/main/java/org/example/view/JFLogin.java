package org.example.view;

import javax.swing.*;

public class JFLogin extends JFrame {
    public JPanel pnPrincipal;
    public JTextField txtUsername;
    public JTextField txtPassword;
    public JButton btnLogin;

    public JFLogin() {
        setContentPane(pnPrincipal);
        setTitle("Iniciar Sesión");
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
