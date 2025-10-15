package org.example.ejercicio02;

import org.example.utils.XmlCtrlDom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void menu() {

        System.out.println("|===============MENÚ===============|");
        System.out.println("|1. - Mostrar todo el XML completo.|");
        System.out.println("|2. - Listar los libros prestados. |");
        System.out.println("|3. - Listar los libros en venta.  |");
        System.out.println("|4. - Salir.                       |");
        System.out.println("|==================================|");
        System.out.println("Elige una opción: ");

    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean salir = false;

        XmlCtrlDom xcd = new XmlCtrlDom();
        Document doc = null;
        File file = new File("./src/main/resources/bookstore.xml");

        while (!salir) {
            menu();
            String opcion = entrada.nextLine();

            try {
                doc = xcd.instanciarDocument(file);
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch (opcion) {
                case "1":
                    System.out.println("1. - Mostrar todo el XML completo.");

                    try {
                        xcd.escribirDocumentXmlPantalla(doc);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "2":
                    System.out.println("2. - Listar los libros prestados.");

                    XPathFactory xPathfactory = XPathFactory.newInstance();
                    XPath xpath = xPathfactory.newXPath();

                    try {
                        NodeList listaPrestados = (NodeList) xcd.evaluarXPathNodos(doc, "/libros/prestamo/libro");
                        int i = 0;
                        while (i < listaPrestados.getLength()) {
                            Node libro =  (Node) listaPrestados.item(i);
                            if (libro.getNodeType() == Node.ELEMENT_NODE) {
                                Element element = (Element) libro;
                                System.out.println("Título: " + element.getElementsByTagName("titulo").item(0).getTextContent() +
                                        " | Autor: " + element.getElementsByTagName("autor").item(0).getTextContent() +
                                        " | Año: " + element.getElementsByTagName("anyo").item(0).getTextContent());
                            }
                            i++;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "3":
                    System.out.println("3. - Listar los libros en venta.");

                    try {
                        NodeList listaPrestados = (NodeList) xcd.evaluarXPathNodos(doc, "/libros/venta/libro");
                        int j = 0;
                        while (j < listaPrestados.getLength()) {
                            Node libro =  (Node) listaPrestados.item(j);
                            if (libro.getNodeType() == Node.ELEMENT_NODE) {
                                Element element = (Element) libro;
                                System.out.println("Título: " + element.getElementsByTagName("titulo").item(0).getTextContent() +
                                        " | Autor: " + element.getElementsByTagName("autor").item(0).getTextContent() +
                                        " | Año: " + element.getElementsByTagName("anyo").item(0).getTextContent());
                            }
                            j++;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "4":
                    System.out.println("4. - Salir.");
                    salir = true;
                    System.out.println("Has salido de la aplicación.");
                    break;
                default:
                    System.out.println("ERROR!!! Opción incorrecta.");
                    break;
            }
        }

    }

}
