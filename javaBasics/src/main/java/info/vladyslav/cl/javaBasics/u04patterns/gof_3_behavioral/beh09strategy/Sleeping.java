package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh09strategy;

public class Sleeping implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}