package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh02command;

public class InsertCommand implements Command {
    Database database;

    public InsertCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.insert();
    }
}
