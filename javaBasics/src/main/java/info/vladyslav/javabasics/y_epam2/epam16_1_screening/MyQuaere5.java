package info.vladyslav.javabasics.y_epam2.epam16_1_screening;

public class MyQuaere5 {
    public static void main(String[] args) {
        int a = 10;
        String name = null;
        try {
            a = name.length();
            a++;
        } catch (RuntimeException e) {
            ++a;
        }
        System.out.println(a);
    }
}
/**
 * What will be the result of the following code fragment?
 *
 * Output information about an exception (I)
 * 11 <-- correct
 * 5
 * 10
 * 12
 */