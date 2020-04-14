package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.banking;

import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manages banking projects...");
    }
}
