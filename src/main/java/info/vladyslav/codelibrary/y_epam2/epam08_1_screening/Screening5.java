package info.vladyslav.codelibrary.y_epam2.epam08_1_screening;

public class Screening5 {
    public static void main(String[] args) {
        int marks = 8;
        int total = 10;
        System.out.println(total < marks && ++marks > 5);
        System.out.println(marks);
        System.out.println(total == 10 || ++marks > 10);
        System.out.println(marks);
    }
}
/**
 * What will be output of the following code in the end?
 * 11
 * 10
 * 9
 * Compilation error
 * 8 <-- correct
 */