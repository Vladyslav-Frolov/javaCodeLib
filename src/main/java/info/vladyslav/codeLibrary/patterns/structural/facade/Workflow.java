package info.vladyslav.codeLibrary.patterns.structural.facade;

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
