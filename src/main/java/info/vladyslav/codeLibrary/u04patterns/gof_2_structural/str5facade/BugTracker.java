package info.vladyslav.codeLibrary.u04patterns.gof_2_structural.str5facade;

public class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint is active");
        activeSprint = true;
    }

    public void fifishSprint() {
        System.out.println("Sprint is not active");
        activeSprint = false;
    }
}
