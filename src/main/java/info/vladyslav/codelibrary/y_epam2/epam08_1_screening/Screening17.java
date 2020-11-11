package info.vladyslav.codelibrary.y_epam2.epam08_1_screening;

public class Screening17 {
}

enum Animals {
    DOG("woof"), CAT("meow"), FISH("burble"); // Line1
    String sound; // Line2

    Animals(String s) {
        sound = s;
    } // Line3
}
class TestEnum{
    static Animals a;

    public static void main(String[] args) {
        System.out.println(a.DOG.sound + " " + a.FISH.sound); // Line4
    }
}

/**
 * What will be the result of the following code?
 * Compilation error on //Line2
 * woof burble <-- correct
 * Compilation error on//Line3
 * Compilation error on//Line1
 * Multiple compile errors
 * Compilation error on//Line4
 */