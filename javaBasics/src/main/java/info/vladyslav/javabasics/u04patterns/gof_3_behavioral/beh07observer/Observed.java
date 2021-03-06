package info.vladyslav.javabasics.u04patterns.gof_3_behavioral.beh07observer;

public interface Observed {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
