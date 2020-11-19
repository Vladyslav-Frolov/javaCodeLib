package info.vladyslav.cl.javaBasics.u01core.core_06_threads;

public class PriorThread extends Thread {
    public PriorThread(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i < 501; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(1); // попробовать sleep(0),sleep(10)
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}
