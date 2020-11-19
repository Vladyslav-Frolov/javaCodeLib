package info.vladyslav.cl.javaBasics.u04patterns.gof_2_structural.str7proxy;

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
