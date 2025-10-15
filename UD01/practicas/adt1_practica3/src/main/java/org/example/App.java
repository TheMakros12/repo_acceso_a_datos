package org.example;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println("|===============MENÚ===============|");
        System.out.println("|1. - Insertar Vehículo            |");
        System.out.println("|2. - Visualizar Vehículos         |");
        System.out.println("|3. - Número de Vehículos por marca|");
        System.out.println("|4. - Salir                        |");
        System.out.println("|==================================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Vehiculo v1;
        Boolean salir = false;
        String rutaArchivo = "./src/main/resources/vehiculos.bin";
        File archivo = new File(rutaArchivo);

        while (!salir) {

            menu();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1. - Insertar un Vehículo.");

                    System.out.println("\t Marca:");
                    String marca = entrada.nextLine();
                    System.out.println("\t Modelo:");
                    String modelo = entrada.nextLine();
                    System.out.println("\t Matrícula:");
                    String matricula = entrada.nextLine();
                    System.out.println("\t Potencia:");
                    int potencia = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("\t Color:");
                    String color = entrada.nextLine();

                    v1 = new Vehiculo(marca, modelo, matricula, potencia, color);

                    try {
                        if (archivo.exists()) {
                            FileOutputStream fos = new FileOutputStream(archivo, true);
                            MiObjectOutputStream mos = new MiObjectOutputStream(fos);
                            mos.writeObject(v1);
                            mos.close();
                            fos.close();
                        } else {
                            FileOutputStream fos = new FileOutputStream(archivo);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(v1);
                            oos.close();
                            fos.close();
                        }
                    } catch (EOFException e1) {
                        System.out.println("Fin de fichero");
                    } catch (FileNotFoundException err) {
                        System.out.println("\tNo existe el archivo: vehiculos.dat.");
                        System.out.println("\tInserta vehiculos antes de visualizar.");
                    } catch (Exception err) {
                        System.out.println("\tError: " + err.toString());
                    }

                    System.out.println("\nHas introducido un nuevo vehículo!");
                    break;
                case 2:
                    System.out.println("2. - Visualizar Vehículos.");

                    try {
                        FileInputStream fis = new FileInputStream(archivo);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        v1 = (Vehiculo) ois.readObject();

                        while (v1 != null) {
                            if (v1 instanceof Vehiculo) {
                                System.out.println(v1);
                            }
                            v1 = (Vehiculo) ois.readObject();
                        }

                        ois.close();
                        fis.close();
                    } catch (EOFException e1) {
                        System.out.println("Fin de fichero");
                    } catch (FileNotFoundException err) {
                        System.out.println("\tNo existe el archivo: vehiculos.dat.");
                        System.out.println("\tInserta vehiculos antes de visualizar.");
                    } catch (Exception err) {
                        System.out.println("\tError: " + err.toString());
                    }
                    break;
                case 3:
                    System.out.println("3. - Visualizar vehículos por marca.");
                    System.out.println(">Introduce una marca: ");
                    String buscarMarca = entrada.nextLine();
                    int contador = 0;

                    try {
                        FileInputStream fis = new FileInputStream(archivo);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        v1 = (Vehiculo) ois.readObject();

                        while (v1 != null) {
                            if (v1.getMarca().equals(buscarMarca)) {
                                System.out.println(v1);
                                contador++;
                            }
                            v1 = (Vehiculo) ois.readObject();
                        }

                        ois.close();
                        fis.close();
                    } catch (EOFException e1) {
                        System.out.println("Fin de fichero");
                    } catch (FileNotFoundException err) {
                        System.out.println("\tNo existe el archivo: vehiculos.dat.");
                        System.out.println("\tInserta vehiculos antes de visualizar.");
                    } catch (Exception err) {
                        System.out.println("\tError: " + err.toString());
                    }

                    System.out.println("En total hay " + contador + " vehículos de la marca " + buscarMarca + ".");
                    break;
                case 4:
                    System.out.println("4. - Salir.");
                    salir = true;
                    System.out.println("Has salido de la aplicación.");
                    break;
                default:
                    System.out.println("ERROR!!! Opción incorrecta.");
                    break;
            }
        }

    }

}