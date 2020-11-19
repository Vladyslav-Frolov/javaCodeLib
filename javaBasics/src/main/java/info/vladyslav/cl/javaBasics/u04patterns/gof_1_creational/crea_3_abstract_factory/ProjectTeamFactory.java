package info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_3_abstract_factory;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}
