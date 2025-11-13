package org.example;

import javax.swing.*;

public class App01  extends JFrame {

    public App01(){
        setTitle("Curso de Java");
        setSize(400,200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new App01();

    }

}