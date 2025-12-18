package org.example.ejercicio02;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.swing.text.Document;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        XmlCtrlDom xmlCtrlDom = new XmlCtrlDom();
        Document document = null;
        File file = new File("./src/main/resources/incidentes.xml");

        List<Incidente> lista = new ArrayList<>();

        lista.add(new Incidente("INC-001", "Batería baja", "Centro", 1.6, "20251122"));
        lista.add(new Incidente("INC-002", "Error GPS", "Puerto", 2.4, "20251121"));
        lista.add(new Incidente("INC-003", "Error altitud", "Universidades", 2.0, "20251120"));
        lista.add(new Incidente("INC-004", "Fallo de motor", "Parque Tecnológico", 3.1, "20251119"));
        lista.add(new Incidente("INC-005", "Desvío de ruta", "Centro", 1.2, "20251118"));

        try {
            document = (Document) xmlCtrlDom.instanciarDocument();


            for (int i = 0; i < lista.size(); i++) {

            }
        } catch (ParserConfigurationException e) {
            e.getStackTrace();
        }

    }

}
