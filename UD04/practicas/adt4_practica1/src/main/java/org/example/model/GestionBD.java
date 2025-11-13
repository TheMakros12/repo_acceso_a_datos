package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class GestionBD {

    private static final String DB = "adt4_practica1";
    private static final String URL = "jdbc:mysql://localhost/" + DB;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static GestionBD db = null;
    private Connection conection = null;

    private GestionBD() {
        try {
            conection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectando a la base de datos de MySQL [" + DB + "]");
        } catch (Exception e) {
            System.err.println("Error conexión [" + DB + "]: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        if (db == null) {
            db = new GestionBD();
        }
        return db.conection;
    }

    public static void desconectar() {
        try {
            db.conection.close();
            System.out.println("Desconectando de la base de datos de MySQL [" + DB + "]");
        } catch (Exception e) {
            System.err.println("Error desconexión [" + DB + "]: " + e.getMessage());
        }
    }

}
