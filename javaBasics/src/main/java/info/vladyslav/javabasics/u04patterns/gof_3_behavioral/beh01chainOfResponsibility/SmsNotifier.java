package info.vladyslav.javabasics.u04patterns.gof_3_behavioral.beh01chainOfResponsibility;

public class SmsNotifier extends Notifier{
    public SmsNotifier(int priority) {
        super(priority);
    }

    @Override
    public void wright(String message) {
        System.out.println("Sending email: " + message);
    }
}
