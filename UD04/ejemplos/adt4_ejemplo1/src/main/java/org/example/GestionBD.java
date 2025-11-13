package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionBD {

    private static final String BD = "adt3_ejemplo1";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/" + BD;

    private static GestionBD db = null;
    Connection conexion = null;

    private GestionBD() {
        try {
            conexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Conectado a la base de datos de MySQL [" + BD + "]");
        } catch (Exception e) {
            System.err.println("Error conexión [" + BD + "]: " + e.getMessage());
        }
    }

    public static Connection getConexion() {
        if (db == null) {
                db = new GestionBD();
        }
        return db.conexion;
    }

    public static void desconectar() {
        try {
            db.conexion.close();
            System.out.println("Desconectando de la base de datos de MySQL [" + BD + "]");
        } catch (SQLException ex) {
            System.err.println("Error desconexión [" + BD + "]: " + ex.getMessage());
        }
    }

}
