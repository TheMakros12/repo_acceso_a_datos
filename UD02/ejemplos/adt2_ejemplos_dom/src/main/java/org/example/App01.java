package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class App01 {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("./src/main/resources/bookstore.xml"));

        document.getDocumentElement().normalize();

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Sacar los elementos hijos de la raíz: ");
        System.out.println("--------------------------------------------------------------------------------");

        Element elementoRaiz = document.getDocumentElement();

        NodeList hijos = document.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            Node hijo = hijos.item(i);
            if (hijo instanceof Element) {
                System.out.println("\t" +  hijo.getNodeName());
            }
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Sacar los precios (2 métodos diferentes): ");
        System.out.println("--------------------------------------------------------------------------------");

        NodeList precios = document.getElementsByTagName("price");

        for (int i = 0; i < precios.getLength(); i++) {
            Node precio = precios.item(i);
            if (precio instanceof Element) {
                System.out.println("\t Método 1: " + precio.getTextContent());
                System.out.println("\t Método 2: " + precio.getFirstChild().getNodeValue());
            }
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Sacar el último precio: ");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("\t" + precios.item(precios.getLength()-1).getTextContent());

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Sacar los atributos de book: ");
        System.out.println("--------------------------------------------------------------------------------");

        NodeList libros =  document.getElementsByTagName("book");

        for (int i = 0; i < libros.getLength(); i++) {
            Node libro = libros.item(i);
            if (libro instanceof Element) {
                if (libro.getAttributes().getNamedItem("category") != null) {
                    System.out.println("\tCategoria: " + libro.getAttributes().getNamedItem("category").getNodeValue());
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Sacar 1 Node a partir de la ruta de XPATH: ");
        System.out.println("--------------------------------------------------------------------------------");

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        Element elementoRaiz2 =  document.getDocumentElement();

        Node nodo = (Node) xPath.evaluate("/bookstore/book[price>35]/price", elementoRaiz2, XPathConstants.NODE);

        System.out.println("\t" + nodo.getTextContent());

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Sacar NodeList a partir de la ruta de XPATH: ");
        System.out.println("--------------------------------------------------------------------------------");

        NodeList lista = (NodeList) xPath.evaluate("/bookstore/book[price>35]/price", elementoRaiz2, XPathConstants.NODESET);

        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo2 = lista.item(i);
            System.out.println("\t" + nodo2.getTextContent());
        }

    }

}