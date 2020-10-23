package info.vladyslav.codeLibrary.u03web.web02xml.xml_04_dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlParserDom {
    public static void main(String[] args) throws Exception {
        /**Загрузка внешнего xml файла в экземпляр класса org.w3c.dom.Document */
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File(
                "src/main/java/info/vladyslav/codeLibrary/u03web/web02xml/xml_04_dom/tutorials.xml"));
        doc.getDocumentElement().normalize();

        /**Получение списка нод и одной ноды по индексу (нумерация с нуля)*/
        NodeList nodeList = doc.getElementsByTagName("tutorial");
        Node first = nodeList.item(0);

        /**альтернативное получение ноды минуя нод лист*/
//        Node first = doc.getElementsByTagName("tutorial").item(0);

        /**Печать данных ноды и количества нод в списке*/
        System.out.println("имя ноды — " + first.getNodeName());
        System.out.println("цифровой код типа ноды — " + first.getNodeType());
        System.out.println("количество нод в листе нод — " + nodeList.getLength());
        System.out.println("константа с кодом элемента ноды — " + Node.ELEMENT_NODE);
        System.out.println("===========================================");

        /**Получение атрибута ноды*/
        NamedNodeMap attrList = first.getAttributes();
        System.out.println("количество атрибутов — " + attrList.getLength());
        System.out.println("имя первого атрибута (нумерация с нуля) — " + attrList.item(0).getNodeName());
        System.out.println("значение первого атрибута (нумерация с нуля) — " + attrList.item(0).getNodeValue());
        System.out.println("===========================================");

        /**Вывод на печать содержания первой ноды*/
        NodeList nodeListForPrint = first.getChildNodes(); // сохранение в списке всех нод потомков первой ноды
        int n = nodeListForPrint.getLength();
        Node current;
        for (int i = 0; i < n; i++) {
            current = nodeListForPrint.item(i); // вынимаем ноду по индексу и сохраняем её
            /*если не сравнивать с основным элементом, то выведутся все типы элементов, не только с кодом "1" */
            if (current.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(
                        current.getNodeName() + ": " + current.getTextContent());
            }
        }
        System.out.println("===========================================");

        /**Замена значения атрибута в загруженном дереве нод, в оригинальном xml ничего не меняется*/
        NodeList nodeListElements = doc.getElementsByTagName("tutorial");
        Element firstElement = (Element) nodeListElements.item(0); // даункаст из ноды к элементу, т. к. элемент наследник ноды
        System.out.println("Значение атрибута type — " + firstElement.getAttribute("type"));
        firstElement.setAttribute("type", "other"); // замена значения атрибута type
        System.out.println("Новое значение атрибута type — " + firstElement.getAttribute("type"));
        System.out.println("===========================================");

        /**Создание нового документа для дальнейшего сохранения в xml*/
        Document newDoc = builder.newDocument();
        Element root = newDoc.createElement("users");
        newDoc.appendChild(root);

        Element firstNode = newDoc.createElement("user");
        root.appendChild(firstNode);
        firstNode.setAttribute("id", "1");

        Element email = newDoc.createElement("email");
        email.appendChild(newDoc.createTextNode("john@example.com"));
        firstNode.appendChild(email);

        System.out.println(newDoc.getChildNodes().getLength());
        System.out.println(newDoc.getChildNodes().item(0).getNodeName());
        System.out.println("===========================================");

        /**Запись нового документа в файл*/
        saveDomToFile(newDoc,
                "src/main/java/info/vladyslav/" +
                        "codeLibrary/u03web/web02xml/xml_04_dom/" +
                        "newxml.xml"); // указать имя и относительный путь

        printDom(newDoc);
    }

    /**Метод сохранения в файл DOM файла*/
    private static void saveDomToFile(Document document,String fileName)
            throws Exception {

        DOMSource dom = new DOMSource(document);
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();

        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(dom, result);
    }

    /**Метод печати ДОМ файла в консоль*/
    private static void printDom(Document document) throws Exception{
        DOMSource dom = new DOMSource(document);
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();

        transformer.transform(dom, new StreamResult(System.out));
    }
}
