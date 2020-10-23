package info.vladyslav.codeLibrary.z_test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.*;
class BeeperControl {
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            public void run() { System.out.println("beep"); }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 2, 2, SECONDS);
        scheduler.schedule(() -> beeperHandle.cancel(true), (60 * 60), SECONDS);
    }
}

class BeeperRun{
    public static void main(String[] args) {
        BeeperControl control = new BeeperControl();
        control.beepForAnHour();
    }
}