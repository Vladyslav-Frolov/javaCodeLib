package info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_5_prototype;

public class ProjectFactory {
    Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    Project cloneProject(){
        return (Project) project.copy();
    }
}
