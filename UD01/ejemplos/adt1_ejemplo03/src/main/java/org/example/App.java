package org.example;

import java.io.File;

public class App {

    public static void main(String[] args) {

        String dir = ".";
        File f = new File(dir);
        String[] files = f.list();

        for (int i = 0; i < files.length; i++) {
            File f2 = new File(f, files[i]);
            System.out.printf("Ficheros en el directorio actual: %b, es Directorio?: %b %n",
                    files[i], f2.isFile(), f2.isDirectory());
        }

    }

}