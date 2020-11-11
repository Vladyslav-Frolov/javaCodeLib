package info.vladyslav.codelibrary.u04patterns.gof_2_structural.str5facade;

public class Developer {
    public void doJobeBeforeDeadLine(BugTracker bugTracker) {
        if (bugTracker.isActiveSprint()) {
            System.out.println("Developer is solving problems...");
        } else {
            System.out.println("Developers is reading Habrhabr...");
        }
    }
}
