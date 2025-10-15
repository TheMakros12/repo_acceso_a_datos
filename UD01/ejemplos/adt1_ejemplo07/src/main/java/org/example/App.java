package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    public static void main(String[] args) {

        String nombre = "./src/main/resources/ejemploObjeto1.data";
        Punto punto = new Punto(52, 5);

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(nombre));
            oos.writeObject(punto);
        } catch (IOException ex) {
            System.out.println("Error escribiendo objeto.");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("Error cerrando escritura.");
                }
            }
        }

    }

}