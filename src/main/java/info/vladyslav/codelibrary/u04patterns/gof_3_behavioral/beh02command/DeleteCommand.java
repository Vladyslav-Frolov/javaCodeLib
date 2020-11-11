package info.vladyslav.codelibrary.u04patterns.gof_3_behavioral.beh02command;

public class DeleteCommand implements Command {
    Database database;

    public DeleteCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}
