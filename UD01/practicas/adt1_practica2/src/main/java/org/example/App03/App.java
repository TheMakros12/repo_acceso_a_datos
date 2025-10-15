package org.example.App03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        File archivo3 = new File("./src/main/resources/ejercicio03.txt");
        FileReader fr = null;

        int contadorVocales = 0;
        int contadorPalabras = 1;

        try {
            fr = new FileReader(archivo3);
            int caracter = fr.read();

            if (caracter == -1) {
                contadorPalabras++;
            }

            while (caracter != -1) {
                char c = (char) caracter;
                if (esVocal(c)) {
                    contadorVocales++;
                } else {
                    if(esEspacio(c)) {
                        contadorPalabras++;
                    }
                }
                caracter = fr.read();
            }
            System.out.println("Número de vocales: " +  contadorVocales + "." +
                    "\nNúmero de palabras: " +  contadorPalabras);
        }  catch(FileNotFoundException ex) {
            System.out.println("Fichero no encontrado.");
        } catch(IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("Error en el finally.");
            }
        }

    }

    public static boolean esVocal(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public static boolean esEspacio(char c) {
        switch (c) {
            case ' ':
                return true;
            default:
                return false;
        }
    }

}
