package info.vladyslav.codeLibrary.patterns.creational.abstractFactory.website;

import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages website project...");
    }
}
