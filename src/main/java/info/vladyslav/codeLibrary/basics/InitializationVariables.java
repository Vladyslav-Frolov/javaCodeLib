package info.vladyslav.codeLibrary.basics;

import java.util.Arrays;

public class InitializationVariables {
    /**
     * НЕСТАТИЧЕСКИЙ контекст
     */
    // объявление полей (в таблицах поле -> это столбец)
    private int a, b, c, d, e, f;

    // объявление полей с динамическим присвоением
    int a1 = 1, b1 = 2, c1 = 3, d1 = 4;

    // (!)будет ошибка компиляции,
    // a = 10;

    /**
     * присвоить не в статическом контексте, если переменная уже объявлена,
     * можно только через конструктор
     */

    // присвоение значения через конструктор
    public InitializationVariables() {
        a = 10;
    }

    //----------------------------------------------------------------------------------
    // объявление массивов, потом, при присвоении, нужно ведялять память через new
    int nums[];

    // объявление массива с 10 элементами, но без присвоения (всегда через new)
    int arr[] = new int[10];

    // объявление массива с динамичесим присвоением (всегда через new)
    char[] ch = new char[]{'b', 'c', 'd', 'e', 'f', 'g'};

    // (!)будет ошибка компиляции,
    // nums = new int []{1, 2};

    /**
     * присвоить не в статическом контексте, если переменная уже объявлена,
     * можно только через конструктор
     */

    public InitializationVariables(int[] n) {
        nums = new int[]{1, 2};
    }

    //----------------------------------------------------------------------------------

    /**
     * СТАТИЧЕСКИЙ контекст
     */
    public static void main(String[] args) {
        // после "= new" всгеда идёт вызов конструктора со скобочками ()
        InitializationVariables vars = new InitializationVariables(new int[10]);
        InitializationVariables vars2 = new InitializationVariables();

        System.out.println(Arrays.toString(vars.nums)); // [1, 2]
        System.out.println(vars2.a); // 10
    }
}
