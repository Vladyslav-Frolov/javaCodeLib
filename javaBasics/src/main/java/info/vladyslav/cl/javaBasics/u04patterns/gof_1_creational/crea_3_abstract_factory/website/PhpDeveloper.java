package info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory.website;

import info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void wrightCode() {
        System.out.println("Php developers wrights php code...");
    }
}
