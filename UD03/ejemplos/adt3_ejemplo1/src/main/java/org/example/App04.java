package org.example;

import java.sql.*;

public class App04 {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo1";
    public static final String USER = "root";
    public static final String PWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PWD);

            String sql = "SELECT nombre, precio, stock "
                    + "FROM articulos;";

            System.out.println(sql);

            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                float precio = resultado.getFloat("precio");
                int stock = resultado.getInt("stock");
                System.out.println("Artículo: " + nombre
                        + " " + precio + "€ " +
                        "- Unidades: " + stock);
            }

            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}
