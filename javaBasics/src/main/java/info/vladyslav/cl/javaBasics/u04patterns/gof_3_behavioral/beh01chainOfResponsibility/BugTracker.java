package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh01chainOfResponsibility;

public class BugTracker {
    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPOTANT);
        Notifier smsNotifier = new SmsNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is OK", Priority.ROUTINE);
        reportNotifier.notifyManager("Something went wrong!", Priority.IMPOTANT);
        reportNotifier.notifyManager("Houston, we have a problem here", Priority.ASAP);
    }
}
