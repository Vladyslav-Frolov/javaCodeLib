package info.vladyslav.javabasics.z_test.old;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Z_9 {
int i = 10;
Integer ii =1000000000;

    public static void main(String[] args) {
        Instant instant = Clock.systemDefaultZone().instant();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.").withZone(ZoneId.systemDefault());
        String formatted = formatter.format(instant);
        System.out.println(formatted);


        String formatted2 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.")
                        .withZone(ZoneId.systemDefault())
                        .format(Clock.systemDefaultZone().instant());

        System.out.println(formatted2);

        // ninja code
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.")
                .withZone(ZoneId.systemDefault()).format(Clock.systemDefaultZone().instant()));


//'2020-10-02 06:53:38.710000'
    }
}
