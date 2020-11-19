package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh11visitor;

public class Test implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}
