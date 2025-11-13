package org.example;

import java.sql.*;

public class App02 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo2";
    public static final String USER = "root";
    public static final String PASSWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWD);

            String sqlMatricular2 = "call matricular2(?,?,?);";
            CallableStatement sentencia = conexion.prepareCall(sqlMatricular2);

            sentencia.registerOutParameter(3, Types.INTEGER);

            sentencia.setInt(1, 1);
            sentencia.setInt(2, 11);
            sentencia.execute();

            if (sentencia.getInt(3) == 0) {
                System.out.println("Matricula realizada.");
            } else {
                System.out.println("El alumno ya se encuentra matriculado de la asignatura.");
            }

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}
