package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.banking;

import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.Developer;

public class JavaDeveloper implements Developer {

    @Override
    public void wrightCode() {
        System.out.println("Java developer wright java code...");
    }
}
