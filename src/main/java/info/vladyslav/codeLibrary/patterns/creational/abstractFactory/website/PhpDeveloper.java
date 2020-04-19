package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.website;

import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void wrightCode() {
        System.out.println("Php developers wrights php code...");
    }
}
