package org.example.App05;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        File origen = new File("./src/main/resources/ejercicio05.txt");
        BufferedReader br = null;

        int numLinea = 1;
        String str = "";

        try {
            System.out.println("Que palabra quieres buscar????");
            String palabra = entrada.nextLine();

            br = new BufferedReader(new FileReader(origen));
            String linea = entrada.nextLine();

            while (linea != null) {
                if (linea.contains(palabra)) {
                    System.out.println("Línea " + numLinea + ": " + linea);
                }
                linea = br.readLine();
                numLinea++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {
                br.close();
                entrada.close();
            } catch (Exception ex) {
                System.out.println("Error en el finally.");
            }
        }

    }

}
