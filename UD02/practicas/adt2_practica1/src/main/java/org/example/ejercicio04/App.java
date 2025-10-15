package org.example.ejercicio04;

import org.example.utils.XmlCtrlDom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws Exception {

        XmlCtrlDom xcd = new XmlCtrlDom();
        Document doc = null;
        File file = new File("./src/main/resources/ejercicio4.xml");

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        doc = builder.newDocument();

        try {
            xcd.instanciarDocument();

            Element elementoRaiz = doc.createElement("alumnos");
            doc.appendChild(elementoRaiz);

            Element nuevoAlumno1 = doc.createElement("alumno");
            nuevoAlumno1.setAttribute("id", "1");

            Element nombreAlumno1 = doc.createElement("nombre");
            nombreAlumno1.setTextContent("Juan");
            nuevoAlumno1.appendChild(nombreAlumno1);

            Element apellidosAlumno1 = doc.createElement("apellidos");
            apellidosAlumno1.setTextContent("Martí López");
            nuevoAlumno1.appendChild(apellidosAlumno1);

            Element edadAlumno1 = doc.createElement("edad");
            edadAlumno1.setTextContent("18");
            nuevoAlumno1.appendChild(edadAlumno1);

            elementoRaiz.appendChild(nuevoAlumno1);

            Element nuevoAlumno2 = doc.createElement("alumno");
            nuevoAlumno2.setAttribute("id", "2");

            Element nombreAlumno2 = doc.createElement("nombre");
            nombreAlumno2.setTextContent("Amparo");
            nuevoAlumno2.appendChild(nombreAlumno2);

            Element apellidosAlumno2 = doc.createElement("apellidos");
            apellidosAlumno2.setTextContent("Luna Dolores");
            nuevoAlumno2.appendChild(apellidosAlumno2);

            Element edadAlumno2 = doc.createElement("edad");
            edadAlumno2.setTextContent("25");
            nuevoAlumno2.appendChild(edadAlumno2);

            elementoRaiz.appendChild(nuevoAlumno2);

            xcd.escribirDocumentXmlFichero(doc, file);
        } catch (Exception ex) {
            Logger.getLogger(org.example.ejercicio02.App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
