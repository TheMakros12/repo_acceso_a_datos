package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class App02 {
    
    public static void main(String[] args) {

        String usuario;
        String password;
        String servidor;
        int puerto;

        Properties configuracion = new Properties();
        try {
            configuracion.load(new FileInputStream("configuracion.props"));
            usuario = configuracion.getProperty("user");
            password = configuracion.getProperty("password");
            servidor = configuracion.getProperty("server");
            puerto = Integer.valueOf(configuracion.getProperty("port"));

            System.out.println(usuario);
            System.out.println(password);
            System.out.println(servidor);
            System.out.println(puerto);

        } catch (FileNotFoundException fnfe ) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
