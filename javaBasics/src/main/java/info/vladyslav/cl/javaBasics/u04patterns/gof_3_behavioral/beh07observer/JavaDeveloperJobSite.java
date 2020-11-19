package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh07observer;

import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed {
    List<String> vacansies = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();

    public void addVacancy(String vacancy) {
        this.vacansies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy) {
        this.vacansies.remove(vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.handleIvent(this.vacansies);
        }

    }
}
