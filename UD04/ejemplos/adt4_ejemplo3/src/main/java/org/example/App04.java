package org.example;

import javax.swing.*;

public class App04 {

    public App04() {
        JOptionPane.showMessageDialog(null,
                "Existen actualizaciones en tu SO",
                "Actualizar el sistema",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        App04 app = new App04();

    }

}
