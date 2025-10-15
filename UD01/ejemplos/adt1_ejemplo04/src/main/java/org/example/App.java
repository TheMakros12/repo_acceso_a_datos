package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App {

    public static void main(String[] args) {

        FileWriter fichero = null;
        PrintWriter escritor = null;

        try {
            fichero = new FileWriter("./src/main/resources/archivo.txt");
            escritor = new PrintWriter(fichero);
            escritor.println("Esto es una línea del fichero.");
        } catch (IOException ioe) {
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException ioe) {

                }
            }
        }

    }

}