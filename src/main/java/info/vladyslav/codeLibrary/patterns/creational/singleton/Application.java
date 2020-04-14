package info.vladyslav.codeLibrary.patterns.creational.singleton;

class Application {
    public static void main(String[] args) {
        Singleton.getInstance().addLogInfo("I make singleton");
        Singleton.getInstance().addLogInfo("Hurrah!!!");
        Singleton.getInstance().showLogInfo();
    }
}
