package info.vladyslav.codeLibrary.patterns.behavioral.chainOfResponsibility;

public class SmsNotifier extends Notifier{
    public SmsNotifier(int priority) {
        super(priority);
    }

    @Override
    public void wright(String message) {
        System.out.println("Sending email: " + message);
    }
}
