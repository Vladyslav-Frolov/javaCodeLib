package info.vladyslav.codeLibrary.patterns.creational.factoryMethod;

public class WindowsButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
