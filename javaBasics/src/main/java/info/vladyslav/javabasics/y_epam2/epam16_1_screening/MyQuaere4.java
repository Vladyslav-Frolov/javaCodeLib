package info.vladyslav.javabasics.y_epam2.epam16_1_screening;

import java.util.Arrays;
import java.util.List;

public class MyQuaere4 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList();
//        Stream.of(l1, l2, l3).map(x -> x + 1).flatMap(x -> x.stream()) forEach(Stream.out::println);
    }
}
/**
 * Which of the following statement is true, given this fragment of code?
 * <p>
 * The code compiles but does not print anything
 * The code thrown an exception
 * The code compiles and prints 123456
 * The code does not compile <-- correct (I)
 * The code runs infinity
 * The code compiles and 234567
 * The code compiles but prints stream references
 */