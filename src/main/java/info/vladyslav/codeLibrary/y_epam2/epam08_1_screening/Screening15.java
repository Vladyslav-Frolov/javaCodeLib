package info.vladyslav.codeLibrary.y_epam2.epam08_1_screening;

public class Screening15 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("+123")); // <-- correct
        System.out.println(Integer.parseInt("123")); // <-- correct
//        System.out.println(Integer.parseInt("123_45"));
        System.out.println(Integer.parseInt("-123")); // <-- correct
//        System.out.println(Integer.parseInt("12ABCD"));
    }
}
