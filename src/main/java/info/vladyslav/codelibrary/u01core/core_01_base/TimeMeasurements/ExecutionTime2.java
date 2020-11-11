package info.vladyslav.codelibrary.u01core.core_01_base.TimeMeasurements;

import java.util.concurrent.TimeUnit;

public class ExecutionTime2 {

    public static void main(String[] args) throws InterruptedException {
        long startTimeL = System.currentTimeMillis();
        calculation();
        long endTimeL = System.currentTimeMillis();

        long output = endTimeL - startTimeL;
        System.out.println("Elapsed time in milliseconds: " + output);
    }

    private static void calculation() throws InterruptedException {

        //Sleep 2 seconds
        TimeUnit.SECONDS.sleep(2);

    }
}
