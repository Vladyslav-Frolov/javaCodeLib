package info.vladyslav.codeLibrary.y_epam2.epam16_1_screening;

import java.util.concurrent.locks.ReentrantLock;

public class ScreeningTest2 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        try {
            lock.lock();
            lock.lock();
        } catch (IllegalArgumentException e) {
            lock.unlock();
            lock.unlock();
        }

    }
}
/**
 * отработает нормально
 */