package info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory.banking;

import info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory.Developer;
import info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory.ProjectManager;
import info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory.ProjectTeamFactory;
import info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory.Tester;

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
