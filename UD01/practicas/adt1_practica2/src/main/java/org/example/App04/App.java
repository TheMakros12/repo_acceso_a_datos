package org.example.App04;

import java.io.*;

public class App {

    public static void main(String[] args) {

        File archivo1 = new File("./src/main/resources/ejercicio04_1.txt");
        File archivo2 = new File("./src/main/resources/ejercicio04_2.txt");

        if (compareFileContent(archivo1, archivo2)) {
            System.out.println("Los archivos son iguales.");
        } else {
            System.out.println("Los archivos son diferentes.");
        }

    }

    public static boolean compareFileContent(File archivo1, File archivo2) {

        FileReader fr1 = null;
        FileReader fr2 = null;
        BufferedReader br1 = null;
        BufferedReader br2 = null;

        String cadena1, cadena2;
        boolean iguales = true;

        try {
            fr1 = new FileReader(archivo1);
            fr2 = new FileReader(archivo2);
            br1 = new BufferedReader(fr1);
            br2 = new BufferedReader(fr2);

            cadena1 = br1.readLine();
            cadena2 = br2.readLine();
            while ((cadena1 != null) && (cadena2 != null) && iguales) {
                if (!cadena1.equals(cadena2)) {
                    iguales = false;
                }
                cadena1 = br1.readLine();
                cadena2 = br2.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error el fichero no existe.");
        } catch (IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {
                if (br1 != null) {
                    br1.close();
                }
                if (br2 != null) {
                    br2.close();
                }
            } catch (IOException ex) {
                System.out.println("Error en el finally.");
            }
        }

        return iguales;
    }

}
