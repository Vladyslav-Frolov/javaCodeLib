package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.banking;

import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.Developer;
import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.ProjectManager;
import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.ProjectTeamFactory;
import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.Tester;

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
