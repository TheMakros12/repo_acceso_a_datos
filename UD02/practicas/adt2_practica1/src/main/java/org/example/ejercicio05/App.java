package org.example.ejercicio05;

import org.example.utils.XmlCtrlDom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {

        XmlCtrlDom xcd = new XmlCtrlDom();
        Document doc = null;
        File file = new File("./src/main/resources/ejercicio5.xml");

        ArrayList<Alumno> lisstaAlumnos = new ArrayList<>();
        Alumno alumnoLeido = null;
        String id, nombre, apellidos, edad;

        try {
            doc = xcd.instanciarDocument(file);

            NodeList alumnos =  doc.getElementsByTagName("alumno");
            for (int i = 0; i < alumnos.getLength(); i++) {
                Node nodoAlumno = alumnos.item(i);
                if (nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoAlumno = (Element) nodoAlumno;
                    id = elementoAlumno.getAttribute("id").toString();
                    nombre = elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                    apellidos = elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent();
                    edad =  elementoAlumno.getElementsByTagName("edad").item(0).getTextContent();
                    alumnoLeido = new Alumno(id, nombre, apellidos, edad);
                }
                lisstaAlumnos.add(alumnoLeido);
            }
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < lisstaAlumnos.size(); i++) {
            System.out.println(lisstaAlumnos.get(i));
        }

    }

}
