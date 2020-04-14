package info.vladyslav.codeLibrary.patterns.creational.singleton;

public class Singleton {
    private static Singleton singleton;
    private static String logFile = "Start log file:\n\n";

    private Singleton() {
    }
    public static synchronized Singleton getInstance() {
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public void addLogInfo(String logString){
        logFile +=logString + "\n";
    }

    public void showLogInfo(){
        System.out.println(logFile);
    }

}
