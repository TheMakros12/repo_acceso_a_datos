package org.example.App02;

import java.io.*;

public class App {

    public static void main(String[] args) {

        File archivoOrigen = new File("./src/main/resources/ejercicio02.txt");
        File archivoDestino = new File("./src/main/resources/ejercicio02_Final.txt");

        FileReader fr = null;
        BufferedReader br = null;

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fr = new FileReader(archivoOrigen);
            br = new BufferedReader(fr);

            fw = new FileWriter(archivoDestino);
            pw = new PrintWriter(fw);

            String cadena = br.readLine();

            while (cadena != null) {
                pw.println(cadena.toUpperCase());
                cadena = br.readLine();
            }

            if (archivoDestino.renameTo(archivoOrigen)) {
                System.out.println("OK");
            } else {
                System.out.println("No OK");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {
                br.close();
                pw.close();
            } catch (IOException ex) {
                System.out.println("Error en el finally.");
            }
        }

    }

}
