package info.vladyslav.codeLibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.website;

import info.vladyslav.codeLibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.Developer;
import info.vladyslav.codeLibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.ProjectManager;
import info.vladyslav.codeLibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.ProjectTeamFactory;
import info.vladyslav.codeLibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.Tester;

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
