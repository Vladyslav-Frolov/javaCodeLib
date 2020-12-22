package info.vladyslav.javabasics.u04patterns.gof_3_behavioral.beh02command;

public class UpdateCommand implements Command {
    Database database;

    public UpdateCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.update();
    }
}
