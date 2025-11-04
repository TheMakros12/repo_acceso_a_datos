package org.example;

import java.sql.*;
import java.util.Scanner;

public class App01 {

    private static final String URL = "jdbc:mysql://localhost/adt3_practica1";
    private static final String USER = "root";
    private static final String PASSWD = "";

    public static void menu() {
        System.out.println("|=============MENÚ=============|");
        System.out.println("|1. - Crear tabla Empleado     |");
        System.out.println("|2. - Insertar nuevo Empleado  |");
        System.out.println("|3. - Borrar Empleado por DNI  |");
        System.out.println("|4. - Listar todos los Empleado|");
        System.out.println("|5. - Salir                    |");
        System.out.println("|==============================|");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        boolean tablaCreada = false;
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWD);
        } catch (SQLException ex) {
            System.out.println("Error SQL 0: " + ex.toString());
        }

        while (!salir) {
            menu();
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1. - Crear tabla Empleado.");

                    String sqlCrearTablaEmpleados = "CREATE TABLE empleados "
                            + "(dni VARCHAR(9) PRIMARY KEY NOT NULL, "
                            + "nombre VARCHAR(50) NOT NULL, "
                            + "apellidos VARCHAR(50) NOT NULL, "
                            + "edad INT NOT NULL, "
                            + "salario FLOAT);";

                    if (conexion != null) {
                        try {
                            PreparedStatement sentenciaCrearTablaEmpleados = conexion.prepareStatement(sqlCrearTablaEmpleados);
                            sentenciaCrearTablaEmpleados.execute();
                            System.out.println("Se ha creado la tabla correctamente!!!");
                        } catch (SQLException ex) {
                            System.out.println("Error SQL 1: " + ex.toString());
                        }
                    }
                    break;
                case 2:
                    System.out.println("2. - Insertar nuevo Empleado.");

                    System.out.println("\tDNI: ");
                    String dni = entrada.nextLine();
                    System.out.println("\tNombre: ");
                    String nombre = entrada.nextLine();
                    System.out.println("\tApellidos: ");
                    String apellidos = entrada.nextLine();
                    System.out.println("\tEdad: ");
                    int edad = Integer.parseInt(entrada.nextLine());
                    System.out.println("\tSalario: ");
                    float salario = Float.parseFloat(entrada.nextLine());

                    String sqlInsertarNuevoEmpleado = "INSERT INTO empleados "
                            + "VALUES('" + dni + "','" + nombre + "','" + apellidos + "'," + edad + "," + salario + ");";

                    if (conexion != null) {
                        try {
                            PreparedStatement sentenciaInsertarEmpleado = conexion.prepareStatement(sqlInsertarNuevoEmpleado);
                            sentenciaInsertarEmpleado.execute();
                            System.out.println("Se ha insertado el Empleado Correctamente!!!");
                        } catch (SQLException ex) {
                            System.out.println("Error SQL 2: " + ex.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("3. - Borrar Empleado por DNI.");

                    System.out.println("\tDNI del Empleado: ");
                    String dniBorrar = entrada.nextLine();

                    String sqlBorrarEmpleado = "DELETE FROM empleados WHERE dni = '" + dniBorrar + "';";

                    if (conexion != null) {
                        try {
                            PreparedStatement sentenciaBorrarEmpleado = conexion.prepareStatement(sqlBorrarEmpleado);
                            int filasAfectadas = sentenciaBorrarEmpleado.executeUpdate();
                            if (filasAfectadas == 1) {
                                System.out.println("Se ha borrado el Empleado con DNI " + dniBorrar);
                            } else {
                                System.out.println("ERROR!!! No se ha podido borrar el Empleado con DNI " + dniBorrar);
                            }
                        } catch (SQLException ex) {
                            System.out.println("Error SQL 3: " + ex.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println("4. - Listar todos los Empleados.");

                    String sqlMostrarEmpleados = "SELECT * FROM empleados;";

                    try {
                        Statement sentenciaMostrarEmpleados = conexion.createStatement();
                        ResultSet resultadoEmpleados = sentenciaMostrarEmpleados.executeQuery(sqlMostrarEmpleados);

                        if (resultadoEmpleados != null) {
                            while (resultadoEmpleados.next()) {
                                for (int i = 1; i < resultadoEmpleados.getMetaData().getColumnCount(); i++) {
                                    System.out.println(resultadoEmpleados.getString(i) + "\t ");
                                }
                                System.out.println();
                            }
                        } else {
                            System.out.println("No hay datos.");
                        }

                        sentenciaMostrarEmpleados.close();
                        resultadoEmpleados.close();
                    } catch (SQLException ex) {
                        System.out.println("Error SQL 4: " + ex.toString());
                    }
                    break;
                case 5:
                    System.out.println("5. - Salir.");
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("ERROR!!! Opción incorrecta.");
                    break;
            }
        }

    }

}