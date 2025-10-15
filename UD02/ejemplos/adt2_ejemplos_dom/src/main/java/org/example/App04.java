package org.example;

import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class App04 {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document document = db.newDocument();

        Element elementoRaiz = document.createElement("books");
        document.appendChild(elementoRaiz);

        Element nuevoElemento = document.createElement("book");
        nuevoElemento.setAttribute("category", "school");
        nuevoElemento.setTextContent("Libro de Acceso a Datos.");

        elementoRaiz.appendChild(nuevoElemento);

        System.out.println("Creació en el árbol DOM en memoría.");

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        Source input = new DOMSource(document);
        Result output = new StreamResult(
                new FileOutputStream(new File("./src/main/resources/ficheroSalida02.xml")));
        transformer.transform(input, output);

        System.out.println("Terminado la creación en el fichero destino.");

    }

}
