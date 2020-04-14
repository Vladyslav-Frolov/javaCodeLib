package info.vladyslav.codeLibrary.patterns.behavioral.observer;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobsite = new JavaDeveloperJobSite();

        jobsite.addVacancy("First Java position");
        jobsite.addVacancy("Second Java position");

        Observer firstSubscriber = new Subscriber("Vladyslav Frolov");
        Observer secondSubscriber = new Subscriber("Peter Romanenko");

        jobsite.addObserver(firstSubscriber);
        jobsite.addObserver(secondSubscriber);

        jobsite.addVacancy("Third Java position");

        jobsite.removeVacancy("First Java position");
    }
}
