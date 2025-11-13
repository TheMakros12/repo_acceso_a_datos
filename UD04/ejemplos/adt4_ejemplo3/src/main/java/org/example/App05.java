package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App05 extends JFrame implements ActionListener {

    JButton btn1 = new JButton("Curso de JavaScript");
    JButton btn2 = new JButton("Curso de PHP");

    public App05() {
        setTitle("Barra de Título");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        add(btn1);
        add(btn2);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btn1) {
            setTitle("Curso de JavaScript");
        } else {
            if (fuente == btn2) {
                setTitle("Curso de PHP");
            }
        }

        repaint();
    }

    public static void main(String[] args) {

        App05 app = new App05();

    }

}
