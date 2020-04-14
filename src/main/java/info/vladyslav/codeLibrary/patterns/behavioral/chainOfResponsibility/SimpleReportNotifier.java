package info.vladyslav.codeLibrary.patterns.behavioral.chainOfResponsibility;

public class SimpleReportNotifier extends Notifier{
    public SimpleReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void wright(String message) {
        System.out.println("Notifying using simple report: " + message);
    }
}
