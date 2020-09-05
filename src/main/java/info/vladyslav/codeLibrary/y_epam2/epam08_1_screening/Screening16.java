package info.vladyslav.codeLibrary.y_epam2.epam08_1_screening;

import java.util.Arrays;

public class Screening16 {
    public static void main(String[] args) {
        int[] random = {6, -4, 12, 0, -10};
        int x = 12;
        int y = Arrays.binarySearch(random, x);
        System.out.println(y);
    }
}
/**
 * What is the result of the following code fragment?
 * 2 <-- correct
 * 6
 * Runtime error
 * The result is undefined
 * 4
 * Compilation error
 */