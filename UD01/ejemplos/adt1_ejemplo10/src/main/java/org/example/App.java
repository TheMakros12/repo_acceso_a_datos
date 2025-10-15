package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        GestionArchivos ga = new GestionArchivos();
        Scanner sc = new Scanner(System.in);

        while (true){
            menuApp();
            String opcion = sc.nextLine();

            switch (Integer.parseInt(opcion)){
                case 1:
                    System.out.print("Indica la nueva ruta de trabajo -> ");
                    String ruta = sc.nextLine();
                    ga.setNombreArchivo(ruta);
                    break;
                case 2:
                    ga.listarRutaTrabajo();
                    break;
                case 7:
                    System.out.println("Salir");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida");

            }

        }

    }

    public static void menuApp(){
        System.out.println("|===============MENÚ===============|");
        System.out.println("|1.- Asignar ruta de trabajo.      |");
        System.out.println("|2.- Listado de la ruta de trabajo.|");
        System.out.println("|7.- Salir.                        |");
        System.out.println("|==================================|");
        System.out.print("Introduce opción: ");
    }
}