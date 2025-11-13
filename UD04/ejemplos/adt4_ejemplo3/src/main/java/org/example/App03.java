package org.example;

import javax.swing.*;
import java.awt.*;

public class App03 extends JFrame {

    public App03() {
        setTitle("Ejemplo Completo");
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        JButton btnPlay = new JButton("Play");
        JButton btnPause = new JButton("Pause");
        JButton btnStop = new JButton("Stop");
        add(btnPlay);
        add(btnPause);
        add(btnStop);

        JLabel lblWeb = new JLabel("Dirección Web: " + JLabel.RIGHT);
        JTextField pageAdress = new  JTextField("Escribe aquí...", 20);
        add(lblWeb);
        add(pageAdress);

        JCheckBox cursoJava = new JCheckBox("Curso Java", true);
        JCheckBox cursoPhp = new JCheckBox("Curso PHP", false);
        JCheckBox cursoKotlin = new JCheckBox("Curso Kotlin", false);
        add(cursoJava);
        add(cursoPhp);
        add(cursoKotlin);

        JComboBox lista = new JComboBox();
        lista.addItem("Java");
        lista.addItem("PHP");
        lista.addItem("Kotlin");
        lista.addItem("C++");
        add(lista);

        JTextArea comentarios = new JTextArea(8, 20);
        add(comentarios);

        setVisible(true);
    }

    public static void main(String[] args) {

        App03 app = new App03();

    }

}
