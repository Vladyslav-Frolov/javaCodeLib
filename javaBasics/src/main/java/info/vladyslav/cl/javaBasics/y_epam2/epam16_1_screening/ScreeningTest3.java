package info.vladyslav.cl.javaBasics.y_epam2.epam16_1_screening;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class ScreeningTest3 {
    public static void main(String[] args) {
        Predicate<String> pr = (s) -> s.startsWith("g");
        Stream str1 = Stream.generate(() -> "gear");
        Stream str2 = Stream.generate(() -> "gear");
        boolean b1 = str1.anyMatch(pr);
        boolean b2 = str2.anyMatch(pr);
        System.out.println(b1 + " " + b2); // true true
    }
}
/**
 * true true
 */