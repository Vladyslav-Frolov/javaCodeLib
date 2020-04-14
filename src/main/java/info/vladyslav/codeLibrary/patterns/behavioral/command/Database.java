package info.vladyslav.codeLibrary.patterns.behavioral.command;

public class Database {
    public void insert() {
        System.out.println("Inserting records...");
    }

    public void update() {
        System.out.println("Updating records...");
    }

    public void select() {
        System.out.println("Reading records...");
    }

    public void delete() {
        System.out.println("Deleting records...");
    }
}
