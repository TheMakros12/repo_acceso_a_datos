package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class App03 {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("./src/main/resources/bookstore.xml"));

        document.getDocumentElement().normalize();

        Element elementoRaiz = document.getDocumentElement();

        Element nuevoElemento = document.createElement("book");
        nuevoElemento.setAttribute("category", "school");

        Text nuevoTexto = document.createTextNode("Libro de Acceso a Datos.");
        nuevoElemento.appendChild(nuevoTexto);

        elementoRaiz.appendChild(nuevoElemento);

        System.out.println("Creación en el árbol DOM en memoria.");

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer idTransform = tf.newTransformer();
        idTransform.setOutputProperty(OutputKeys.METHOD, "xml");
        idTransform.setOutputProperty(OutputKeys.INDENT, "yes");
        Source input = new DOMSource(document);
        Result output = new StreamResult(new FileOutputStream(new File("./src/main/resources/ficheroSalida01.xml")));
        idTransform.transform(input, output);

        System.out.println("Terminado la creación en el fichero de destino.");

    }

}
