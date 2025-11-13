package org.example;

import java.sql.*;

public class App06 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PASSWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWD);
            DatabaseMetaData dataBaseMetaData = conexion.getMetaData();

            ResultSet resultado = dataBaseMetaData.getTables(null, null, null, args);
            while (resultado.next()) {
                System.out.println("Tabla: ");
                System.out.println("    " + resultado.getString(3) + " ( " + resultado.getString(4) + " )");

                ResultSet resultado2 = dataBaseMetaData.getColumns(null, resultado.getString(2), resultado.getString(3), null);
                while (resultado2.next()) {
                    System.out.println("    " + resultado2.getString(4) + " ( " + resultado2.getString(6) + " )");
                }
                System.out.println("");
            }

            resultado.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}
