package org.example;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println("|============MENÚ============|");
        System.out.println("|1. - Insertar un Lego       |");
        System.out.println("|2. - Visualizar Legos       |");
        System.out.println("|3. - Buscar un Lego por ID  |");
        System.out.println("|4. - Mostrar total de piezas|");
        System.out.println("|5. - Mostrar precio total   |");
        System.out.println("|6. - Salir                  |");
        System.out.println("|============================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        Lego l1;
        String rutaArchivo = "./src/main/resources/lego.bin";
        File f = new File(rutaArchivo);

        while (!salir) {

            menu();
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1. - insertar un Lego.");

                    System.out.println("\tID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("\tCategoria: ");
                    String categoria = sc.nextLine();
                    System.out.println("\tModelo: ");
                    String modelo = sc.nextLine();
                    System.out.println("\tPiezas: ");
                    int piezas = sc.nextInt();
                    sc.nextLine();
                    System.out.println("\tPrecio: ");
                    float precio = sc.nextFloat();
                    sc.nextLine();

                    l1 = new Lego(id, categoria, modelo, piezas, precio);

                    try {
                        if (f.exists()) {
                            FileOutputStream fos = new FileOutputStream(f, true);
                            MiObjectOutputStream mos = new MiObjectOutputStream(fos);
                            mos.writeObject(l1);
                            mos.close();
                            fos.close();
                        } else {
                            FileOutputStream fos = new FileOutputStream(f);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(l1);
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
                    System.out.println("2. - Visualizar Legos,");

                    try {
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        l1 = (Lego) ois.readObject();

                        while (l1 != null) {
                            if (l1 instanceof Lego) {
                                System.out.println(l1);
                            }
                            l1 = (Lego) ois.readObject();
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
                    System.out.println("3. -  Buscar un Lego por ID.");

                    try {
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        System.out.println("Introduce un ID: ");
                        int buscarID = sc.nextInt();
                        sc.nextLine();

                        l1 = (Lego) ois.readObject();

                        while (l1 != null) {
                            if (l1.getId() == buscarID) {
                                System.out.println(l1);
                            }
                            l1 = (Lego) ois.readObject();
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
                    System.out.println("4. - Mostrar el total de piezas");

                    int totalPiezas = 0;

                    try {
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        l1 = (Lego) ois.readObject();

                        while (l1 != null) {
                            if (l1 instanceof Lego) {
                                totalPiezas += l1.getPiezas();
                            }
                            l1 = (Lego) ois.readObject();
                        }

                        System.out.println("ID no encontrado");

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

                    System.out.println("El total de piezas es: " + totalPiezas);
                    break;
                case 5:
                    System.out.println("4. - Mostrar el precio total: ");

                    float totalPRecio = 0;

                    try {
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        l1 = (Lego) ois.readObject();

                        while (l1 != null) {
                            if (l1 instanceof Lego) {
                                totalPRecio += l1.getPrecio();
                            }
                            l1 = (Lego) ois.readObject();
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

                    System.out.println("El precio total es: " + totalPRecio + "€");
                    break;
                case 6:
                    System.out.println("7. - Salir.");
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
