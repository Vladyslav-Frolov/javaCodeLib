package info.vladyslav.cl.javaBasics.u01core.core_01_base;

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
    // объявление массивов, потом, при присвоении, нужно выдялять память через new
    int nums[];

    // объявление массива с 10 элементами, но без присвоения (всегда через new)
    int arr[] = new int[10];

    // объявление массива с динамичесим присвоением (всегда через new)
    char[] ch = new char[]{'b', 'c', 'd', 'e', 'f', 'g'};

    // объявление пустого массива
    char[] chr = {};

    // (!)будет ошибка компиляции,
    // nums = new int []{1, 2};

    /**
     * присвоить не в статическом контексте, если переменная уже объявлена,
     * можно только через конструктор
     */

    // принимаемый аргумент не участвует в работе тела конструктора
    public InitializationVariables(int[] n) {
        nums = new int[]{1, 2};
    }

    // конструктор для вывода анонимных массивов, переданных в аргументах
    public InitializationVariables(int[] n, int[] n2) {
        System.out.print(Arrays.toString(n));
        System.out.println(Arrays.toString(n2));
    }

    //----------------------------------------------------------------------------------

    /**
     * СТАТИЧЕСКИЙ контекст
     */
    public static void main(String[] args) {
        // после "= new" всгеда идёт вызов конструктора со скобочками ()
        InitializationVariables vars = new InitializationVariables(new int[10]);
        InitializationVariables vars2 = new InitializationVariables();
        InitializationVariables vars3 =
                new InitializationVariables(new int[2], new int[]{9, 10, 11}); // [0, 0][9, 10, 11]

        System.out.println(Arrays.toString(vars.nums)); // [1, 2]
        System.out.println(vars2.a); // 10
    }
}
