package codelibrary.u03web.web02xml.xml_04_dom;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class XmlParserDomTest {


@BeforeClass


    @Test
    public void whenGetElementByTag_thenSuccess() {
        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(new File(
                    "src/main/java/info/vladyslav/codelibrary/u03web/web02xml/xml_04_dom/tutorials.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();




        NodeList nodeList = doc.getElementsByTagName("tutorial");
        Node first = nodeList.item(0);

        assertEquals(1, nodeList.getLength());
        assertEquals(Node.ELEMENT_NODE, first.getNodeType());
        assertEquals("tutorial", first.getNodeName());
    }

//    @After

}