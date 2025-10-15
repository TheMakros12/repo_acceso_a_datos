package org.example;

import java.io.*;

public class App {

    public static void main(String[] args) {

        File fichero = null;
        BufferedReader buffer = null;

        try {
            fichero = new File("./src/main/resources/archivo.txt");
            buffer = new BufferedReader(new FileReader(fichero));
            String linea = null;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Exception e) {

                }
            }
        }

    }

}