package org.example;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class App02 {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("./src/main/resources/bookstore.xml"));

            document.getDocumentElement().normalize();

            NodeList lista = document.getElementsByTagName("book");
            for (int i = 0; i < lista.getLength(); i++) {
                Node padre = lista.item(i);
                NodeList listaHijos = padre.getChildNodes();

                for (int j = 0; j < listaHijos.getLength(); j++) {
                    Node hijo = listaHijos.item(j);
                    if ("title".equals(hijo.getNodeName())) {
                        System.out.println(hijo.getFirstChild().getNodeValue());
                    } else {
                        if (hijo.getNodeName() == "price") {
                            System.out.println("\tPrecio: " +  hijo.getFirstChild().getNodeValue() + "€");
                        }
                    }
                }
                System.out.println("\tCategoria: " + padre.getAttributes().getNamedItem("category").getNodeValue());
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(App02.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
