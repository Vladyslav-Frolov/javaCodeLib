package info.vladyslav.codeLibrary.patterns.structural.facade;

public class Developer {
    public void doJobeBeforeDeadLine(BugTracker bugTracker) {
        if (bugTracker.isActiveSprint()) {
            System.out.println("Developer is solving problems...");
        } else {
            System.out.println("Developers is reading Habrhabr...");
        }
    }
}
