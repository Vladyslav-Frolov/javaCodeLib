package info.vladyslav.javabasics.z_test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.*;

class BeeperControl {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {

        final Runnable beeper = () -> System.out.println("beep");

        // первая задержка 5 сек. и все последующие 1 сек.
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 5, 1, SECONDS);

        // период всего выполнения 10 секунд
        scheduler.schedule(() -> beeperHandle.cancel(true), 10 , SECONDS);

    }
}

class BeeperRun {
    public static void main(String[] args) {
        BeeperControl control = new BeeperControl();
        control.beepForAnHour();
    }
}