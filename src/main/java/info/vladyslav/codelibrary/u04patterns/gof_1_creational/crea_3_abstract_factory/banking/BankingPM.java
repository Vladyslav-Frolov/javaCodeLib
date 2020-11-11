package info.vladyslav.codelibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.banking;

import info.vladyslav.codelibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manages banking projects...");
    }
}
