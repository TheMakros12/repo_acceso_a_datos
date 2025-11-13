package org.example;

import javax.swing.*;
import java.awt.*;

public class App02  extends JFrame {

    public App02() {
        setTitle("Ejemplo PlayBack");
        setSize(225,80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        JButton btnPlay = new JButton("Play");
        JButton btnPause = new JButton("Pause");
        JButton btnStop = new JButton("Stop");
        add(btnPlay);
        add(btnPause);
        add(btnStop);

        setVisible(true);
    }

    public static void main(String[] args) {

        new App02();

    }

}
