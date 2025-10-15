package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class GestionArchivos {

    private String rutaTrabajo;

    public  GestionArchivos() {
        rutaTrabajo = File.listRoots()[0].toString();
    }

    public String getRutaTrabajo() {
        return rutaTrabajo;
    }

    public void setRutaTrabajo(String rutaTrabajo) {
        this.rutaTrabajo = rutaTrabajo;
    }

    public void listarRutaTrabajo() {

        File ruta = new File(rutaTrabajo);
        File[] listaFicheros = ruta.listFiles();

        for(File contenido : listaFicheros) {
            if (contenido.isDirectory()) {
                System.out.println("(D): " + contenido);
            } else {
                System.out.println("(F): " + contenido);
            }
        }

    }

    public String mostrarInformacionDetallada(String nombreArchivo) {
        StringBuilder resultado = new StringBuilder();
        File archivo = new File(rutaTrabajo);

        if (!archivo.exists()) {
            System.out.println("ERROR!!! No se puede obtener información de: " + nombreArchivo + ". No existe.");
            return "";
        }

        if (!archivo.canRead()) {
            System.out.println("ERROR!!! No se puede acceder a " + nombreArchivo + ". No tienes permisos.");
            return "";
        }

        resultado.append("INFORMACIÓN DEL SISTEMA");
        resultado.append("\n\n");

        resultado.append("Nombre: ");
        resultado.append(nombreArchivo);
        resultado.append("\n");

        resultado.append("Tipo: ");
        if (archivo.isFile()) {
            resultado.append("Fichero: ");
            resultado.append("\n");

            resultado.append("Longitud: ");
            resultado.append(archivo.length());
            resultado.append("\n");
        } else {
            resultado.append("Carpeta: ");
            resultado.append("\n");

            resultado.append("Contenido: ");
            resultado.append(archivo.list().length);
            resultado.append(" entradas\n");
        }

        resultado.append("Ubicación: ");
        try {
            resultado.append(archivo.getCanonicalPath());
        } catch (IOException ex) {
        }

        resultado.append("\n");

        resultado.append("Última modificación: ");
        Date fecha = new Date(archivo.lastModified());
        resultado.append(fecha.toString());
        resultado.append("\n");

        resultado.append("Oculto: ");
        resultado.append((archivo.isHidden()) ? "Sí" : "No");
        resultado.append("\n");

        if (archivo.isDirectory()) {
            resultado.append("Espacio libre: ");
            resultado.append(archivo.getFreeSpace());
            resultado.append("\n");

            resultado.append("Espacio disponible: ");
            resultado.append(archivo.getUsableSpace());
            resultado.append("\n");

            resultado.append("Espacio total: ");
            resultado.append(archivo.getTotalSpace());
            resultado.append("\n");
        }

        return resultado.toString();
    }

    public void crearDirectorio(String nombreArchivo) {
        File carpetaDeTrabajo = new File(rutaTrabajo);
        File archivo = new File(rutaTrabajo, nombreArchivo);

        if (!carpetaDeTrabajo.canWrite()) {
            System.out.println("ERROR!!! No se ha podido crear " +  nombreArchivo + ". No tienes permisos.");
            return;
        }

        if (carpetaDeTrabajo.exists()) {
            System.out.println("ERROR!!! No se ha podido crear. Ja existe una carpeta o archivo con el nombre " +  nombreArchivo);
            return;
        }

        if (!carpetaDeTrabajo.mkdir()) {
            System.out.println("ERROR!!! No se ha podido crear " +  nombreArchivo + ".");
        }
    }

    public void crearArchivo(String nombreArchivo) {
        File carpetaDeTrabajo = new File(rutaTrabajo);
        File archivo = new File(rutaTrabajo, nombreArchivo);

        if (!carpetaDeTrabajo.canWrite()) {
            System.out.println("ERROR!!! No se ha podido crear " + nombreArchivo + ". No tienes permisos.");
            return;
        }

        if (archivo.exists()) {
            System.out.println("ERROR!!! No se ha podido crear. Ja existe un archivo o carpeta con el nombre " + nombreArchivo + ".");
            return;
        }

        try {
            if (!archivo.createNewFile()) {
                System.out.println("ERROR!!! No se ha podido crear " + nombreArchivo + ".");
                return;
            }
        } catch (IOException ex) {
            System.out.println("Se ha producido un errror de entrada o de salida: "
                    + ex.getMessage());
        }
    }

    public void eliminarFichero(String nombreArchivo) {
        File carpetaDeTrabajo = new File(rutaTrabajo);
        File archivo = new File(rutaTrabajo, nombreArchivo);

        if (!archivo.exists()) {
            System.out.println("ERROR!!! No se ha podido eliminar, pero no existe un archivo con el nombre " + nombreArchivo + ".");
            return;
        }

        if (!archivo.canWrite()) {
            System.out.println("ERROR!!! No se ha podido eliminar " + nombreArchivo + ". No tienes suficientes permisos.");
            return;
        }

        if (!archivo.delete()) {
            System.out.println("ERROR!!! No se ha podido eliminar " + nombreArchivo + ".");
        } else {
            System.out.println("Fichero eliminado correctamente.");
        }
    }

}
