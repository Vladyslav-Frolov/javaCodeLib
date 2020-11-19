package info.vladyslav.cl.javaBasics.y_epam2.epam08_1_screening;

public class Screening2 {
    public static void main(String[] args) {
        int total = 0;
        StringBuilder lettrs = new StringBuilder("abdefg");
        total += lettrs.substring(1, 2).length();
        total += lettrs.substring(6, 6).length();
        total += lettrs.substring(6, 5).length();
        System.out.println(total);
    }
}
/**
 * What will be the result of the following code:
 * 1
 * 7
 * The code does not compile <-- correct
 * 2
 * An exception is thrown
 * 3
 */