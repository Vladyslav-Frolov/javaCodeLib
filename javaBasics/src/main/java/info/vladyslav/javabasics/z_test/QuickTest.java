package info.vladyslav.javabasics.z_test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QuickTest {
    public static void main(String[] args) {
        System.out.println(java.time.ZonedDateTime.now());
        System.out.println(java.time.LocalDateTime.now());
        System.out.println(new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime()));
    }

}
