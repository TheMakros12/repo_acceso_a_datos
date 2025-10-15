package org.example;

import java.io.File;

public class App {

    public static void main(String[] args) {

        File f = new File("./src/main/resources/file.txt");

        if(f.exists()){
            System.out.println("El archivo si que existe.");
        } else {
            System.out.println("El archivo no existe.");
        }

        System.out.println("getName(): " + f.getName());
        System.out.println("getParent(): " + f.getParent());
        System.out.println("length(): " + f.length());

    }

}