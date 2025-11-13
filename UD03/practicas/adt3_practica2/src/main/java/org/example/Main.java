package org.example;

import java.sql.*;

public class Main {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo2";
    public static final String USER = "root";
    public static final String PASSWD = "";

    public static void main(String[] args) {

        try  {
            Connection conexion = DriverManager.getConnection(URL,USER,PASSWD);

            String sql = "call matriclar3 (?,?,?);";
            CallableStatement sentencia = conexion.prepareCall(sql);

            sentencia.registerOutParameter(3, Types.INTEGER);

            sentencia.setInt(1,1);
            sentencia.setInt(2,11);

            sentencia.execute();
            switch (sentencia.getInt(3)) {
                case 0:
                    System.out.println("Matrícula realizada.");
                    break;
                case 1:
                    System.out.println("El alumno no existe.");
                    break;
                case 2:
                    System.out.println("La asignatura no existe.");
                    break;
                case 3:
                    System.out.println("El Alumno ya se encuentra matriculado en la asignatura.");
                    break;
                default:
                    System.out.println("Error!!!");
                    break;
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}