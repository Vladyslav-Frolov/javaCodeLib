package info.vladyslav.codeLibrary.u04patterns.gof_2_structural.str5facade;

public class Workflow {
    Developer developer = new Developer();
    Job job = new Job();
    BugTracker bugTracker = new BugTracker();
    public void solveProblems(){
        job.doJob();
        bugTracker.startSprint();
        developer.doJobeBeforeDeadLine(bugTracker);
    }
}
