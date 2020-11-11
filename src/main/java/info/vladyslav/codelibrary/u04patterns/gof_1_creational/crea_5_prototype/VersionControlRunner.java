package info.vladyslav.codelibrary.u04patterns.gof_1_creational.crea_5_prototype;

public class VersionControlRunner {
    public static void main(String[] args) {
        Project master = new Project(1, "Project", "Source code sourceCode = new SourceCode();");

        System.out.println(master);

        ProjectFactory factory = new ProjectFactory(master);
        Project masterClone = factory.cloneProject();

        System.out.println("=================================\n");
        System.out.println(masterClone);

    }
}
