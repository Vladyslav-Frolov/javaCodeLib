package info.vladyslav.codeLibrary.basics;

public class SumOfAllDigits {
    public static void main(String[] args) {
        int a = 555; // любое число
        int suma = 0;

        do {
            suma += a % 10;
            a /= 10; }
        while ((a % 10) != 0);

        System.out.println(suma);
    }
}