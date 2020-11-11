package info.vladyslav.codelibrary.u01core.core_06_threads;

public class ExceptionThreadDemo {
    public static void main(String[ ] args) throws InterruptedException {
        new ExceptThread().start();
        Thread.sleep(1000);
        System.out.println("end of main");
    }
}
