package info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_2_factory_method.facM1;

public class WindowsButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
