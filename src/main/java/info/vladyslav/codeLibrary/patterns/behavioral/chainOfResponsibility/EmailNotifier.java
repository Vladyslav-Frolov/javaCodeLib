package info.vladyslav.codeLibrary.patterns.behavioral.chainOfResponsibility;

public class EmailNotifier extends Notifier{
    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    public void wright(String message) {
        System.out.println("Sending email: " + message);
    }
}
