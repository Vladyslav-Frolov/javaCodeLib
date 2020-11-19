package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh01chainOfResponsibility;

public abstract class Notifier {
    private int priority;
    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String message, int level) {
        if (level >= priority) {
            wright(message);
        }
        if (nextNotifier != null) {
            nextNotifier.notifyManager(message, level);
        }
    }

    public abstract void wright(String message);
}
