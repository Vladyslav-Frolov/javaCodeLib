package info.vladyslav.codeLibrary.patterns.behavioral.templateMethod;

public class NewsPage extends WebsiteTemplate{
    @Override
    public void showPageContent() {
        System.out.println("News");
    }
}
