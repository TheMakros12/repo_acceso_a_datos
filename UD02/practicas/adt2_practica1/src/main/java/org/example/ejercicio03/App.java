package org.example.ejercicio03;

import org.example.utils.XmlCtrlDom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {

        XmlCtrlDom xcd = new XmlCtrlDom();
        Document doc = null;
        File file = new File("./src/main/resources/bookstore.xml");
        File file2 = new File("./src/main/resources/ejercicio3.xml");

        try {
            doc = xcd.instanciarDocument(file);
            Node prestamos = xcd.evaluarXPathNodos(doc, "/libros/prestamo");

            Element nuevoLibro = doc.createElement("libro");
            nuevoLibro.setAttribute("isbn", "12345678");

            Element titulo =  doc.createElement("titulo");
            titulo.setTextContent("Nuevo libro de ejemplo");
            nuevoLibro.appendChild(titulo);

            Element autor =  doc.createElement("autor");
            autor.setTextContent("Autor de prueba");
            nuevoLibro.appendChild(autor);

            Element anyo =   doc.createElement("anyo");
            anyo.setTextContent("2026");
            nuevoLibro.appendChild(anyo);

            Element editorial =  doc.createElement("editorial");
            editorial.setTextContent("Editorial Simarro");
            nuevoLibro.appendChild(editorial);

            prestamos.appendChild(nuevoLibro);

            xcd.escribirDocumentXmlFichero(doc, file2);

        } catch (Exception ex) {
            Logger.getLogger(org.example.ejercicio02.App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
