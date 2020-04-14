package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.website;

import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void wrightCode() {
        System.out.println("Php developers wrights php code...");
    }
}
