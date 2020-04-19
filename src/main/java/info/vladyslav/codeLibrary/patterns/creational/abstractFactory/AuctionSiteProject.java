package info.vladyslav.codeLibrary.patterns.creational.abstractFactory;

import info.vladyslav.codeLibrary.patterns.creational.abstractFactory.website.WebsiteTeamFactory;

public class AuctionSiteProject {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebsiteTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("Create auction website...");
        developer.wrightCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
