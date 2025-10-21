package org.example.ejercicio07;

import org.example.ejercicio07.Alumno;
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
        File file = new File("./src/main/resources/ejercicio6.xml");

        ArrayList<Alumno> listaDAM = new ArrayList<>();
        ArrayList<Alumno> listaASIR = new ArrayList<>();
        Alumno alumnoLeido = null;
        String id, nombre, apellidos, curso;
        int nota;

        try {
            doc = xcd.instanciarDocument(file);

            NodeList listaAlumnos =  doc.getElementsByTagName("alumno");
            for (int i = 0; i < listaAlumnos.getLength(); i++) {
                Node alumno =  listaAlumnos.item(i);
                if (alumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoAlumno = (Element) alumno;
                    id =  elementoAlumno.getAttribute("id").toString();
                    nombre = elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                    apellidos = elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent();
                    nota =  elementoAlumno.getElementsByTagName("nota").item(0).getTextContent().charAt(0);
                    curso = elementoAlumno.getElementsByTagName("curso").item(0).getTextContent();
                    alumnoLeido = new Alumno(id, nombre, apellidos, nota, curso);

                    if (curso.equals("2nDAM")) {
                        listaDAM.add(alumnoLeido);
                    } else {
                        listaASIR.add(alumnoLeido);
                    }
                }
            }

            System.out.println("LISTA DE DAM");
            for (Alumno alumno : listaDAM) {
                System.out.println(alumno);
            }

            System.out.println("LISTA DE ASIR");
            for (Alumno alumno : listaASIR) {
                System.out.println(alumno);
            }
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(org.example.ejercicio05.App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
