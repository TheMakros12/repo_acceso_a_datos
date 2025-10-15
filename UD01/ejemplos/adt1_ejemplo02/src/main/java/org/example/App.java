package org.example;

import java.io.File;

public class App {

    public static void main(String[] args) {

        String directorioRaiz = File.listRoots().toString();
        File[] paths = File.listRoots();
        File direcC = new File("C:/");

        System.out.println("============================================");
        System.out.println("DirectorioRaiz: " + directorioRaiz);

        System.out.println("============================================");
        System.out.println("Unidades de disco: ");
        for (File f : paths) {
            System.out.println("\t" + f.toString());
        }

        System.out.println("============================================");
        System.out.println("Los archivos y/o carpetas que contiene " + direcC);
        for (File f : direcC.listFiles()) {
            System.out.println("\t" + f + (f.isFile() ? " - fichero" : " - directorio"));
        }

        System.out.println("============================================");
        System.out.println("Los nombres de los archivos y/o carpetas que contiene " + direcC);
        for (String f : direcC.list()) {
            System.out.println("\t" + f);
        }

    }

}