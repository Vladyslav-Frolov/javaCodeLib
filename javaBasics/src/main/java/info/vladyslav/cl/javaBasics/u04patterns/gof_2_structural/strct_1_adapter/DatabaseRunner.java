package info.vladyslav.cl.javaBasics.u04patterns.gof_2_structural.strct_1_adapter;

public class DatabaseRunner {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();

        database.insert();
        database.update();
        database.select();
        database.remove();
    }
}
