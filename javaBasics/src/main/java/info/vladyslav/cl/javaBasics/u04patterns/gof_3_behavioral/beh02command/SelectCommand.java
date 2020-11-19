package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh02command;

public class SelectCommand implements Command {
    Database database;

    public SelectCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.select();
    }
}
