package info.vladyslav.codeLibrary.u03web.web02xml.xml_05_sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxRunner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        ArticleHandler articleHandler = new ArticleHandler();
        saxParser.parse("src/main/java/info/vladyslav/" +
                "codeLibrary/u03web/web02xml/xml_05_sax/" +
                "test.xml", articleHandler);

        System.out.println(articleHandler.getWebsite());
        ArticleList result = articleHandler.getWebsite();
        System.out.println("========================================================");

        List<ArticleStrings> articles = result.getArticleList();
        System.out.println(articles.size());
        System.out.println("========================================================");

        ArticleStrings articleOne = articles.get(0);
        System.out.println(articleOne.getTitle());
        System.out.println(articleOne.getContent());
        System.out.println("========================================================");

        ArticleStrings articleTwo = articles.get(1);
        System.out.println(articleTwo.getTitle());
        System.out.println(articleTwo.getContent());
        System.out.println("========================================================");

        ArticleStrings articleThree = articles.get(2);
        System.out.println(articleThree.getTitle());
        System.out.println(articleThree.getContent());
    }
}
