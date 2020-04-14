package info.vladyslav.codeLibrary.patterns.creational.abstractFactory;

import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.banking.BankingTeamFactory;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("Creating bank system: ");
        developer.wrightCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
