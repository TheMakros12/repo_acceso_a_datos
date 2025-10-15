package org.example;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    public static void main(String[] args) {

        escribeFichero("./src/main/resources/mascotas.dat");
        anyadeFichero("./src/main/resources/mascotas.dat");
        leeFichero("./src/main/resources/mascotas.dat");

    }

    public static void escribeFichero(String fichero) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero));
            for (int i = 0; i < 5; i++) {
                Persona p = new Persona(i);
                out.writeObject(p);
            }

            out.close();
            System.out.println("Cierro fichero.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void anyadeFichero(String fichero) {
        try {
            MiObjectOutputStream out = new MiObjectOutputStream(new FileOutputStream(fichero, true));

            Persona p = new Persona(5);
            for (int i = 0; i < 5; i++) {
                p.setPersona(i);
                out.writeUnshared(p);
            }

            out.close();
            System.out.println("Cierro fichero por segunda vez.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leeFichero(String fichero) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero));
            Object aux = in.readObject();

            while (aux != null) {
                if (aux instanceof Persona) {
                    System.out.println(aux);
                }
                aux = in.readObject();
            }
            in.close();
        } catch (EOFException e1) {
            System.out.println("Fin de fichero");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

}