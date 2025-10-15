package org.example;

import java.io.File;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println("|==================MENÚ==================|");
        System.out.println("|1. - Asignar una ruta de trabajo.       |");
        System.out.println("|2. - Mostrar la ruta de trabajo.        |");
        System.out.println("|3. - Información de achivo o directorio.|");
        System.out.println("|4. - Crea un directorio.                |");
        System.out.println("|5. - Crea un fichero.                   |");
        System.out.println("|6. - Elimina un fichero.                |");
        System.out.println("|7. - Salir.                             |");
        System.out.println("|========================================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        GestionArchivos ga = new GestionArchivos();

        while (!salir) {

            menu();
            String opcion = entrada.next();

            switch (opcion) {
                case "1":
                    System.out.println("\t1. - Asignar una ruta de trabajo.");
                    ga.setRutaTrabajo(entrada.nextLine());
                    break;
                case "2":
                    System.out.println("\t2. -  Mostrar la ruta de trabajo.");
                    ga.listarRutaTrabajo();
                    break;
                case "3":
                    System.out.println("\t3. - Información de achivo o directorio.");
                    System.out.println(ga.mostrarInformacionDetallada(entrada.nextLine()));
                    break;
                case "4":
                    System.out.println("\t4. Crea un directorio.");
                    ga.crearDirectorio(entrada.nextLine());
                    break;
                case "5":
                    System.out.println("\t5. -  Crea un fichero.");
                    ga.crearArchivo(entrada.nextLine());
                    break;
                case "6":
                    System.out.println("\t6. - Elimina un fichero.");
                    ga.eliminarFichero(entrada.nextLine());
                    break;
                case "7":
                    System.out.println("\t7. - Salir.");
                    salir = true;
                    break;
                default:
                    System.out.println("ERROR!!! Opción incorrecta.");
                    break;
            }
        }

        System.out.println("Has salido de la aplicación.");

    }

}