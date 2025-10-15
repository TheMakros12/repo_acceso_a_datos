package org.example.ejercicio01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class App {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("./src/main/resources/bookstore.xml"));

        doc.getDocumentElement().normalize();

        Element elementoRaiz = doc.getDocumentElement();
        NodeList listaNodos = doc.getElementsByTagName("libro");

        System.out.println("Nodo raíz: " + elementoRaiz.getNodeName());
        System.out.println("Total de libros: " + listaNodos.getLength());

        System.out.println("===================================================================");

        NodeList secciones = elementoRaiz.getChildNodes();
        for (int i = 0; i < secciones.getLength(); i++) {
            Node seccion = secciones.item(i);
            if (seccion.getNodeType() == Node.ELEMENT_NODE) {
                String tipo = seccion.getNodeName();
                NodeList listaLibros = seccion.getChildNodes();

                for (int j = 0; j < listaLibros.getLength(); j++) {
                    Node nodoLibro = listaLibros.item(j);
                    if (nodoLibro.getNodeType() == Node.ELEMENT_NODE) {
                        Element libro = (Element) nodoLibro;

                        System.out.println("Sección : " + seccion.getNodeName() + " | ISBN: "
                                + libro.getAttribute("isbn") +
                                " | Titulo: " + libro.getElementsByTagName("titulo").item(0).getTextContent() +
                                " | Autor: " + libro.getElementsByTagName("autor").item(0).getTextContent() +
                                " | Año: " + libro.getElementsByTagName("anyo").item(0).getTextContent());
                    }
                }
            }
        }

    }

}