package org.example;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.err;

public class App {

    public static void menu() {
        System.out.println("|=================MENÚ=================|");
        System.out.println("|1. - Insertar un Lego                 |");
        System.out.println("|2. - Visualizar los Lego              |");
        System.out.println("|3. - Visualizar los Lego por Categoria|");
        System.out.println("|4. - Salir                            |");
        System.out.println("|======================================|");
        System.out.println("Elige una opción:");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        Lego lego;
        String rutaArchivo = "./src/main/resources/lego.bin";
        File archivo = new File(rutaArchivo);

        while(!salir) {
            menu();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch(opcion) {
                case 1:
                    System.out.println("1. - Insertar Lego.");

                    System.out.println("1. - insertar un Lego.");

                    System.out.println("\tID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("\tCategoria: ");
                    String categoria = entrada.nextLine();
                    System.out.println("\tModelo: ");
                    String modelo = entrada.nextLine();
                    System.out.println("\tPiezas: ");
                    int piezas = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("\tPrecio: ");
                    float precio = entrada.nextFloat();
                    entrada.nextLine();

                    lego = new Lego(id, categoria, modelo, piezas, precio);

                    try {
                        if (archivo.exists()) {
                            FileOutputStream fos = new FileOutputStream(archivo, true);
                            MiObjectOutputStream mos = new MiObjectOutputStream(fos);
                            mos.writeObject(lego);
                            mos.close();
                            fos.close();
                        } else {
                            FileOutputStream fos = new FileOutputStream(archivo);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(lego);
                            oos.close();
                            fos.close();
                        }

                        System.out.println("Has introducido un nuevo Lego.");
                    } catch (EOFException e1) {
                        System.out.println("Fin de fichero");
                    } catch (FileNotFoundException err) {
                        System.out.println("\tNo existe el archivo: vehiculos.dat.");
                        System.out.println("\tInserta vehiculos antes de visualizar.");
                    } catch (Exception err) {
                        System.out.println("\tError: " + err.toString());
                    }

                    break;
                case 2:
                    System.out.println("2. - Visualizar todos los Lego.");
                    break;
                case 3:
                    System.out.println("3. - Visualizar Lego por categoria.");
                    break;
                case 4:
                    System.out.println("4. - Salir.");
                    salir = true;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    break;
            }
        }

    }

}
