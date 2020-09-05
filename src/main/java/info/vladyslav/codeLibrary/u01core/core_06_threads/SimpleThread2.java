package info.vladyslav.codeLibrary.u01core.core_06_threads;

public class SimpleThread2 extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.print(e);
        }
        System.out.println("end of SimpleThread");
    }
}