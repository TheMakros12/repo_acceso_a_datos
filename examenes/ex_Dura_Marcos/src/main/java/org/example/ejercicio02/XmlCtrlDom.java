package org.example.ejercicio02;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XmlCtrlDom {

    public XmlCtrlDom() {
    }

    public Document instanciarDocument()
            throws ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Crea un arbol DOM vacío
        Document document = db.newDocument();

        return document;
    }

    public Document instanciarDocument(File fXmlFile)
            throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Representa el documento XML en DOM
        Document document = db.parse(fXmlFile);

        // Para eliminar nodos de textos vacios
        document.getDocumentElement().normalize();

        return document;
    }

    public NodeList evaluarXPathNodos(Document doc, String expresion)
            throws Exception {

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();

        return (NodeList) xp.evaluate(expresion, doc, XPathConstants.NODESET);
    }

    public void escribirDocumentXmlFichero(Document doc, File file)
            throws TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        trans.transform(source, result);
    }

    public void escribirDocumentXmlPantalla(Document doc) throws TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult pantalla = new StreamResult(System.out);
        trans.transform(source, pantalla);
    }
}
