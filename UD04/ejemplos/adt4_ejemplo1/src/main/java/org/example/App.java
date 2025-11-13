package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        try {
            Connection accesoBD = GestionBD.getConexion();

            String sqlInsertar = "INSERT INTO articulos "
                    + "(id, nombre, precio, stock, imagen, descripcion) "
                    + "VALUES ('111', 'Bicicleta', 450.00, 5, NULL, 'BH')";
            System.out.println(sqlInsertar);

            Statement sentenciaInsertar = accesoBD.createStatement();
            int filas = sentenciaInsertar.executeUpdate(sqlInsertar);
            System.out.println("Filas insertadas: " + filas);

            sentenciaInsertar.close();
            accesoBD.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

}