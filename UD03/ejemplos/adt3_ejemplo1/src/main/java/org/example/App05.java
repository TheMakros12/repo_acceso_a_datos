package org.example;

import java.sql.*;

public class App05 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PWD);

            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet result = null;

            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String user = dbmd.getUserName();

            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println("===================================");
            System.out.println("Nombre: " + nombre);
            System.out.println("Driver: " + driver);
            System.out.println("URL: " + url);
            System.out.println("Usuario: " + user);

            result = dbmd.getTables(null, "adt3_ejemplo1", null, null);

            while (result.next()) {
                String catalogo = result.getString(1);
                String esquema = result.getString(2);
                String tabla = result.getString(3);
                String tipo = result.getString(4);
                System.out.println(tipo + " - Catálogo: " + catalogo +
                        ", Esquema: " + esquema + ", Nombre: " + tabla);

                System.out.println("Columnas Tabla");
                System.out.println("================================");
                ResultSet columnas = null;
                columnas = dbmd.getColumns(null, "adt3_ejemplo1", tabla, null);
                while (columnas.next()) {
                    String nombreCo1 = columnas.getString("COLUMN_NAME");
                    String tipoCo1 = columnas.getString("TYPE_NAME");
                    String tamCo1 = columnas.getString("COLUMN_SIZE");
                    String nulla = columnas.getString("IS_NULLABLE");

                    System.out.println("\tColumna: " + nombreCo1 + " - Tipo: " +
                            tipo + " - Tamaño: " + tamCo1 + " - ¿Nula?: " + nulla);
                }
            }

            result.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}
