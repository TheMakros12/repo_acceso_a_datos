package org.example.ejercicio01;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println("|=================MENÚ=================|");
        System.out.println("|1. - Insertar Incidente.              |");
        System.out.println("|2. - Mostrar Incidentes por categoria.|");
        System.out.println("|3. - Salir.                           |");
        System.out.println("|======================================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        Incidente incidente;
        String rutaArchivo = "./src/main/resources/incidentes.dat";
        File file = new File(rutaArchivo);

        while (!salir) {
            menu();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1. - Insertar Incidente.");
                    System.out.println("\tTipo: ");
                    String tipo = entrada.nextLine();
                    System.out.println("\tGravedad: ");
                    int gravedad = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("\tFecha (DD/MM/AAAA): ");
                    String fecha = entrada.nextLine();

                    incidente = new Incidente(tipo, gravedad, fecha);

                    try {
                        if (file.exists()) {
                            FileOutputStream fos = new FileOutputStream(file, true);
                            MiObjectOutputStream mos = new MiObjectOutputStream(fos);
                            mos.writeObject(incidente);
                            mos.close();
                            fos.close();
                        } else {
                            FileOutputStream fos = new FileOutputStream(file);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(incidente);
                            oos.close();
                            fos.close();
                        }
                    } catch (IOException e) {
                        e.getStackTrace();
                    }

                    System.out.println("Has introducido un nuevo Incidente!");
                    break;
                case 2:
                    System.out.println("2. - Mostar Incidentes por categoria.");

                    int categoria1 = 0;
                    int categoria2 = 0;
                    int categoria3 = 0;

                    try {
                        FileInputStream fis = new FileInputStream(file);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        incidente = (Incidente) ois.readObject();

                        while (incidente != null) {
                            int aux = incidente.getGravedad();
                            switch (aux) {
                                case 1:
                                    categoria1++;
                                    break;
                                case 2:
                                    categoria2++;
                                    break;
                                case 3:
                                    categoria3++;
                                    break;
                                default:
                                    System.out.println("ERROR");
                                    break;
                            }
                            incidente = (Incidente) ois.readObject();
                        }
                    } catch (IOException e) {
                        e.getStackTrace();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("INCIDENTES TOTALES:");
                    System.out.println("\tGravedad 1 - Número de Incidentes: " + categoria1);
                    System.out.println("\tGravedad 2 - Número de Incidentes: " + categoria2);
                    System.out.println("\tGravedad 3 - Número de Incidentes: " + categoria3);
                    break;
                case 3:
                    System.out.println("3. - Salir.");
                    salir = true;
                    System.out.println("Has salido de la aplicación.");
                    break;
                default:
                    System.out.println("ERROR!!! Opción incorrecta");
                    break;
            }
        }

    }

}
