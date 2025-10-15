package org.example.App01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println("|============MENÚ============|");
        System.out.println("|1. - Leer desde el fichero. |");
        System.out.println("|2. - Escribir en el fichero.|");
        System.out.println("|3. - Salir.                 |");
        System.out.println("|============================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            menu();
            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("1. - Leer desde el fichero.");
                    System.out.println("Introduce la ruta del fichero que quieres leer: ");
                    String rutaFichero = entrada.next();

                    try {
                        FileReader archivo = new FileReader(rutaFichero);
                        BufferedReader br = new BufferedReader(archivo);
                        String linea;

                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea + " ");
                        }
                    } catch (IOException err) {
                        System.out.println("Error: " + err.toString());
                    }
                    break;
                case 2:
                    System.out.println("2. - Escribir desde fichero.");
                    System.out.println("Introduce la ruta del fichero que quieres escribir: ");
                    String linea = entrada.next();

                    try {
                        FileWriter fw = new FileWriter(linea, true);

                        System.out.println("\nIntroduce una frase para escribir: ");
                        String frase = entrada.next();

                        fw.write(frase);

                        fw.close();
                    } catch(IOException err) {
                        System.out.println("Error: " + err.toString());
                    }
                    break;
                case 3:
                    System.out.println("3. - Salir.");
                    salir = true;
                    break;
                default:
                    break;
            }
        }

        try {
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error en el finally.");
        }

    }

}