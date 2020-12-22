package info.vladyslav.javabasics.u03web.web02xml.xml_05_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ArticleHandler extends DefaultHandler {
    private static final String ARTICLES = "articles";
    private static final String ARTICLE = "article";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";

    private ArticleList website;
    private String elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startDocument() throws SAXException {
        website = new ArticleList();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case ARTICLES:
                website.setArticleList(new ArrayList<>());
                break;
            case ARTICLE:
                website.getArticleList().add(new ArticleStrings());
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case TITLE:
                latestArticle().setTitle(elementValue);
                break;
            case CONTENT:
                latestArticle().setContent(elementValue);
                break;
        }
    }

    private ArticleStrings latestArticle() {
        List<ArticleStrings> articleList = website.getArticleList();
        int latestArticleIndex = articleList.size() - 1;
        return articleList.get(latestArticleIndex);
    }

    public ArticleList getWebsite() {
        return website;
    }
}