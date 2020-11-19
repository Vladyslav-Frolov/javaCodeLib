package info.vladyslav.cl.javaBasics.y_epam2.epam08_1_screening;

public class Screening13 {
    public static void main(String[] args) {
        String varWithSpace = " AB CB ";
        System.out.print(":");
        System.out.print(varWithSpace.trim());
        System.out.print(":");
    }
}

/**What will be the result of the following code?
 * ::
 * :ABCB:
 * :AB CB: <-- correct
 * Compilation error
 * */
