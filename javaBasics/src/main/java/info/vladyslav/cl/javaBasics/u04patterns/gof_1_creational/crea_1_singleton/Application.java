package info.vladyslav.cl.javaBasics.u04patterns.gof_1_creational.crea_1_singleton;

class Application {
    public static void main(String[] args) {
        Singleton.getInstance().addLogInfo("I make crea_1_singleton");
        Singleton.getInstance().addLogInfo("Hurrah!!!");
        Singleton.getInstance().showLogInfo();
    }
}
