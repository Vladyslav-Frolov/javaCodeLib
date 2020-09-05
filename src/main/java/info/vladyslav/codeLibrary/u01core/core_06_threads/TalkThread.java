package info.vladyslav.codeLibrary.u01core.core_06_threads;

public class TalkThread extends Thread{
    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println("Talking — " + count);
            try {
                Thread.sleep(7); // остановка на 7 миллисекунд
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}