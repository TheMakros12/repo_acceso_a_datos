package org.example;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println("|===============MENÚ===============|");
        System.out.println("|1. - Insertar Piloto.             |");
        System.out.println("|2. - Visualizar Piloto.           |");
        System.out.println("|3. - Buscar Piloto por número.    |");
        System.out.println("|4. - Buscar Piloto por escuderia. |");
        System.out.println("|5. - Mostrar victorias por Piloto.|");
        System.out.println("|6. - Salir                        |");
        System.out.println("|==================================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        Piloto p1;
        File archivo = new File("./src/main/resources/pilotos.bin");

        while (!salir) {
            menu();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1. - Insertar Piloto.");

                    System.out.println("\t Número:");
                    int num = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("\t Nombre:");
                    String nombre = entrada.nextLine();
                    System.out.println("\t Apellidos:");
                    String apellido = entrada.nextLine();
                    System.out.println("\t Escuderia:");
                    String escuderia = entrada.nextLine();
                    System.out.println("\t Victorias:");
                    int victorias = entrada.nextInt();
                    entrada.nextLine();

                    p1 = new Piloto(num, nombre, apellido, escuderia, victorias);

                     try {
                         if (archivo.exists()) {
                             FileOutputStream fos = new FileOutputStream(archivo, true);
                             MiObjectOutputStream mos = new MiObjectOutputStream(fos);
                             mos.writeObject(p1);
                             mos.close();
                             fos.close();
                         } else {
                             FileOutputStream fos = new FileOutputStream(archivo, true);
                             ObjectOutputStream oos = new ObjectOutputStream(fos);
                             oos.writeObject(p1);
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

                    System.out.println("\nHas introducido un nuevo Piloto");
                    break;
                case 2:
                    System.out.println("2. - Visualizar Piloto.");

                    try{
                     FileInputStream fis = new FileInputStream(archivo);
                     ObjectInputStream ois = new ObjectInputStream(fis);

                     p1 = (Piloto) ois.readObject();

                     while (p1 != null) {;
                         if (p1 instanceof Piloto) {
                             System.out.println(p1);
                         }
                         p1 = (Piloto) ois.readObject();
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
                    System.out.println("3. - Buscar Piloto por número.");

                    System.out.println("\t>Introduce el número del Piloto: ");
                    int numero = entrada.nextInt();

                    try {
                        FileInputStream fis = new FileInputStream(archivo);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        p1 = (Piloto) ois.readObject();

                        while (p1 != null) {
                            if (p1.getNum() == numero) {
                                System.out.println(p1);
                            }
                            p1 = (Piloto) ois.readObject();
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
                    case 4:
                    System.out.println("3. - Buscar Piloto por escuderia.");

                    System.out.println("\t>Introduce el nombre de la escuderia: ");
                    String escuderiaABuscar = entrada.nextLine();

                    try {
                        FileInputStream fis = new FileInputStream(archivo);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        p1 = (Piloto) ois.readObject();

                        while (p1 != null) {
                            if (p1.getEscuderia().equals(escuderiaABuscar)) {
                                System.out.println(p1);
                            }
                            p1 = (Piloto) ois.readObject();
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
                case 5:
                    System.out.println("3. - Mostrar victorias por Piloto.");

                    System.out.println("\t>Introduce el nombre del Piloto: ");
                    String nombrePiloto = entrada.nextLine();

                    try {
                        FileInputStream fis = new FileInputStream(archivo);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        p1 = (Piloto) ois.readObject();

                        while (p1 != null) {
                            if ((p1.getNombre().concat(" " + p1.getApellido())).equals(nombrePiloto)) {
                                System.out.println(p1.getNombre() + " " + p1.getApellido() + " tiene " + p1.getVictoria() + " victorias.");
                            }
                            p1 = (Piloto) ois.readObject();
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
                case 6:
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
