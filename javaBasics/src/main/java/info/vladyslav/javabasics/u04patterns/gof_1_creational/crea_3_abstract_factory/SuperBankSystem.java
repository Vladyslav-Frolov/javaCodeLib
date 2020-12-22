package info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_3_abstract_factory;

import info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_3_abstract_factory.banking.BankingTeamFactory;

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
