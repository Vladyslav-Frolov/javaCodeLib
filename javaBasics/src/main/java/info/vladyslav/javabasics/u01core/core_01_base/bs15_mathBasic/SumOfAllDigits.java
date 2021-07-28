package info.vladyslav.javabasics.u01core.core_01_base.bs15_mathBasic;

public class SumOfAllDigits {
    public static void main(String[] args) {
        int a = 555; // любое число
        int suma = 0; // обязательная инициализация

        do {
            suma += a % 10;
            a /= 10; }
        while ((a % 10) != 0);

        // вывод суммы
        System.out.println(suma);
    }
}
