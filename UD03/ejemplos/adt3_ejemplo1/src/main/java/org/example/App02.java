package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App02 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PWD);

            String sql = "UPDATE articulos SET stock = ?;";

            System.out.println(sql);

            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, 10);

            int filas = sentencia.executeUpdate();

            System.out.println("Filas actualizadas: " + filas);

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}
