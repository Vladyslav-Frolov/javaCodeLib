package info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_3_abstract_factory.website;

import info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_3_abstract_factory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages website project...");
    }
}
