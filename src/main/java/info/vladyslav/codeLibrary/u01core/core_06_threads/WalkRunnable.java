package info.vladyslav.codeLibrary.u01core.core_06_threads;

public class WalkRunnable implements Runnable {
    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println("Walking — " + count);
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}