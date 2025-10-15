package org.example;

import java.io.*;

public class App {

    public static void main(String[] args) {

        String fichero = "./src/main/resources/ejemplo06.data";
        String nombre = "IIP";
        int conv = 1;
        double nota = 7.8;

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fichero));
            out.writeUTF(nombre);
            out.writeInt(conv);
            out.writeDouble(nota);
            out.close();

            DataInputStream in = new DataInputStream(new FileInputStream(fichero));
            System.out.println("Valor leído de nombre: " + in.readUTF());
            System.out.println("Valor leído de convocatoria: " + in.readInt());
            System.out.println("Valor leído de nota: " + in.readDouble());
            in.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Problemas con el fichero " + fichero + "." + fnfe.getMessage());
        } catch (IOException e) {
            System.err.println("Problemas al escribir ene l fichero " + fichero);
        }

    }

}