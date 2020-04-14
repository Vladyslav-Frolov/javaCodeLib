package info.vladyslav.codeLibrary.patterns.creational.factoryMethod;

public class HTTPButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
