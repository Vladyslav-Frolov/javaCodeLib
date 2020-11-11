package info.vladyslav.codelibrary.u04patterns.gof_1_creational.crea_3_abstract_factory;

import info.vladyslav.codelibrary.u04patterns.gof_1_creational.crea_3_abstract_factory.website.WebsiteTeamFactory;

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
