package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App01 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo2";
    public static final String USER = "root";
    public static final String PASSWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWD);

            String sqlMatricular1 = "call matricular1(?,?);";
            CallableStatement sentencia = conexion.prepareCall(sqlMatricular1);

            sentencia.setInt(1, 1);
            sentencia.setInt(2, 10);
            sentencia.execute();
            System.out.println("matrícula realizada.");

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}