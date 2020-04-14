package info.vladyslav.codeLibrary.patterns.structural.proxy;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new ProxyProject("http://www...");
        project.run();
    }
}
