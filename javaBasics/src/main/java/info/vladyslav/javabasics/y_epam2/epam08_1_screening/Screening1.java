package info.vladyslav.javabasics.y_epam2.epam08_1_screening;

public class Screening1 {
    public static void main(String[] args) {
        int m = 9, n = 1, x = 0;
        while (m > n) {
            m--;
            n += 2;
            x += m + n;
        }
        System.out.println(x);
    }
}
/**
 * What is the result of the following code fragment:
 * 36 <-- correct
 * 83
 * 100
 * 126
 */