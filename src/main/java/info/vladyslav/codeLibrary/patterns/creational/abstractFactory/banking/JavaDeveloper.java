package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.banking;

import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.Developer;

public class JavaDeveloper implements Developer {

    @Override
    public void wrightCode() {
        System.out.println("Java developer wright java code...");
    }
}
