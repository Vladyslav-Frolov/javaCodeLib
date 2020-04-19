package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.banking;

import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manages banking projects...");
    }
}
