package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.banking;

import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.Developer;
import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.ProjectManager;
import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.ProjectTeamFactory;
import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
