package org.example;

import org.example.generadores.GeneradorNombres;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Random;

public class App {

    public static final String URL = "jdbc:mysql://localhost/adt3_ejemplo3";
    public static final String USER = "root";
    public static final String PASSWD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWD);

            insertarContactoDB(conexion, generarContactoAleatorio());
            mostrarDatosContactoDB(conexion);
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }

    }

    public static Contacto generarContactoAleatorio() {
        String nombre = GeneradorNombres.generarConApellido();
        String correo = nombre.replaceAll(" ", "-").toLowerCase() + "@iessimarro.com";
        int telefono = new Random().nextInt(600000000, 700000000);
        String rutaImagen = "./src/main/resources/rutaImagen/default.jpg";

        return new Contacto(nombre, correo, rutaImagen, telefono);
    }

    public static void insertarContactoDB(Connection conex, Contacto contacto) {
        try {
            final byte[] binarioImagen = Files.readAllBytes(Paths.get(contacto.getImagen()));

            String queryInsertar = "INSERT INTO contactos(nombre, correo, telefono, imagen,  binarioImagen) VALUES(?,?,?,?,?);";
            PreparedStatement queryFinalInsertar = conex.prepareStatement(queryInsertar);
            queryFinalInsertar.setString(1, contacto.getNombre());
            queryFinalInsertar.setString(2, contacto.getCorreo());
            queryFinalInsertar.setInt(3, contacto.getTelefono());
            queryFinalInsertar.setString(4, contacto.getImagen());
            queryFinalInsertar.setBytes(5, binarioImagen);

            if (queryFinalInsertar.executeUpdate() > 0) {
                System.out.println("'" + contacto.getNombre() + "' se ha insertado correctamente.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarDatosContactoDB(Connection conex) throws SQLException {

        String querySelect = "SELECT nombre, correo, telefono, imagen FROM contactos;";
        PreparedStatement query = conex.prepareStatement(querySelect);
        ResultSet contactos = query.executeQuery();

        while (contactos.next()) {
            Contacto contacto = new Contacto(
                    contactos.getString("nombre"),
                    contactos.getString("correo"),
                    contactos.getString("imagen"),
                    contactos.getInt("telefono"));
            contacto.mostrarDatos();
        }
    }

    public static void descargarImagenContactosDB(Connection conex) throws SQLException, IOException {
        String querySelectImagen = "SELECT imagen, binarioImagen FROM contactos;";
        PreparedStatement query = conex.prepareStatement(querySelectImagen);
        ResultSet contactos = query.executeQuery();

        while (contactos.next()) {
            Blob blob = contactos.getBlob("binarioImagen");
            byte[] blobBytes = blob.getBytes(1, (int) blob.length());

            String rutaImagen = contactos.getString("imagen");

            FileOutputStream fos = new FileOutputStream(rutaImagen);
            fos.write(blobBytes);
            fos.close();
        }
    }

    public static void cargarImagenesContactosDB(Connection conex, String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);

        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            for (File archivo : archivos) {
                if (archivo.isFile() && esJpg(archivo.getName())) {
                    Contacto contacto = generarContactoAleatorio();
                    contacto.setImagen(archivo.getPath());
                    insertarContactoDB(conex, contacto);
                }
            }
        } else {
            System.out.println("La ruta proporcionada no es una carpeta válida.");
        }
    }

    public static boolean esJpg(String fileName) {
        if (fileName.length() < 4) {
            return false;
        } else {
            String extension = fileName.substring(fileName.length() - 4);
            return extension.equalsIgnoreCase(".jpg");
        }
    }

    public static void mostrarImagenContacto(Connection conex, Contacto contacto) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(contacto.getImagen()));
            } else {
                throw new Exception("Desktop is not supported");
            }
        } catch (Exception e) {
            System.out.println("ERROR: no se ha podido mostrar la imagen del contacto");
        }
    }

}
