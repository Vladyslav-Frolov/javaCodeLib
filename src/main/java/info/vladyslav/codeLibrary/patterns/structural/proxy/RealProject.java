package info.vladyslav.codeLibrary.patterns.structural.proxy;

/**
 * для скачивания репозитория на гит хабе
 */
public class RealProject implements Project {
    String url;

    public RealProject(String url) {
        this.url = url;
        load();
    }

    public void load() {
        System.out.println("Loading project from " + url + "...");
    }

    @Override
    public void run() {
        System.out.println("Running project"+ url + "...");
    }
}
