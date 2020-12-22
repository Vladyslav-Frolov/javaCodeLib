package info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_3_abstract_factory.banking;

import info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_3_abstract_factory.Developer;

public class JavaDeveloper implements Developer {

    @Override
    public void wrightCode() {
        System.out.println("Java developer wright java code...");
    }
}
