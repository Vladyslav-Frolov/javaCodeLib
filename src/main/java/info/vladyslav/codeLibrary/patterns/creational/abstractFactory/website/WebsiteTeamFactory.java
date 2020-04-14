package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.website;

import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.Developer;
import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.ProjectManager;
import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.ProjectTeamFactory;
import info.vladyslav.EPAM_HW_09_1223.creational.abstractFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
