package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh11visitor;

public interface Developer {
    public void create(ProjectClass projectClass);

    public void create(Database database);

    public void create(Test test);
}
