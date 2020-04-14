package info.vladyslav.codeLibrary.patterns.creational.prototype;

public class ProjectFactory {
    Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    Project cloneProject(){
        return (Project) project.copy();
    }
}
