package info.vladyslav.codeLibrary.u01core.core_06_threads;

public class ExceptionMainDemo {
    public static void main(String[ ] args) {
        new SimpleThread2().start();
        System.out.println("end of main with exception");
        throw new RuntimeException();
    }
}
