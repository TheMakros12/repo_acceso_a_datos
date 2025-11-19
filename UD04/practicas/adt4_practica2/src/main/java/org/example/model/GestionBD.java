package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionBD {

    private static final String BD = "adt4_practica2";
    private static final String URL = "jdbc:mysql://localhost/" + BD;
    private static final String USER = "root";
    private static final String PASSW = "";

    private static GestionBD db = null;
    private Connection connection = null;

    private GestionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSW);
        } catch (Exception e) {
            System.err.println("Error conexión [" + BD + "]: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (db == null) {
            db = new GestionBD();
        }
        return db.connection;
    }

    public static void deconectar() {
        try {
            db.connection.close();
            System.out.println("Desconectado de la base de datos MySQL [" + BD + "]");
        } catch (SQLException ex) {
            System.err.println("Error desconexión [" + BD + "]: " + ex.getMessage());
        }
    }

}
