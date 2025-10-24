package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App01 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PSW = "";

    public static void main(String[] args) {

        try {
            Connection conexio = DriverManager.getConnection(URL, USER, PSW);

            String sql = "INSERT INTO articulos "
                    + "(id, nombre, precio, stock, imagen, descripcion) "
                    + "VALUES('b1', 'Bicicleta', 450.00, 5, NULL,'BH');";

            System.out.println(sql);

            Statement sentencia = conexio.createStatement();

            int filas = sentencia.executeUpdate(sql);

            System.out.println("Filas insertadas: " + filas);

            sentencia.close();
            conexio.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
    }

}