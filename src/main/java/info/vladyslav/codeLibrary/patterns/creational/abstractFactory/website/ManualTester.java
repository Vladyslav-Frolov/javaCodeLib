package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.website;

import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Tester tests website...");
    }
}
