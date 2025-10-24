package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App05 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PWD);


        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}
