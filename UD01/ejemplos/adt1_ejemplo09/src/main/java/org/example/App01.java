package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class App01 {

    public static void main(String[] args) {

        String miUsuario = "Marcos";
        String miContrasena = "11111";
        String elServidor = "https://wwww.simarro.org";
        String elPuerto = "8080";

        Properties configuracion = new Properties();
        configuracion.setProperty("user", miUsuario);
        configuracion.setProperty("password", miContrasena);
        configuracion.setProperty("server", elServidor);
        configuracion.setProperty("port", elPuerto);
        try {
            configuracion.store(new FileOutputStream("configuracion.props"),
                    "Fichero de configuracion");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}