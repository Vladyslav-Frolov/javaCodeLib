package info.vladyslav.cl.javaBasics.u01core.core_01_base;

import java.util.Arrays;

public class ArraysBasic {
    /**
     * НЕстатический контекст
     */
    int[] i;
    int b[];
    int[][] c;
    int[] arrVoid = new int[10];
    int[] arrDinamic = {1, 2, 3, 4, 5};
    int[] arrDinamic2 = new int[]{6, 7, 8, 9, 10};

    //      это ошибочной подход в нестатическом контексте, в статическом это работает,
    //      в обявленные переменные не возможно позже добавить данные, только чреез блок кода или метод/конструктор
    //      i = new int[]{1, 2, 3};
    //      c = new int[][]{{1, 2},{7,3}};
    {
        i = new int[]{1, 2, 3};
    }

    {
        c = new int[][]{{1, 2}, {7, 3}};
    }

    /**
     * статический контекст
     */
    public static void main(String[] args) {
        // объявление переменной одномерного массива, все виды
        int[] i; // ← эталонный способ
        int b[];

        // объявление переменной двумерного массива, все способы
        int[][] c; // ← эталонный способ
        int[] d[];
        int e[][];

        // дальнейшее присвоение только через new
        i = new int[]{1, 2, 3};
        c = new int[][]{{1, 2}, {7, 3}};
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.deepToString(c));

        // этот способ ошибочен
//        b = {1, 2, 3};

        // динамическая инициализация переменной одномерного массива 2-х типов
        int[] arrDinamic = {1, 2, 3, 4, 5};
        int[] arrDinamic2 = new int[]{6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arrDinamic));
        System.out.println(Arrays.toString(arrDinamic2));


        // присвоение по умолчанию
        int[] arrayInt = new int[10]; // на печать выведет "0" (нули)
        float[] arrayFloat = new float[10]; // на печать выведет "0.0"
        boolean[] arrayBool = new boolean[10]; // на печать выведет "false"
        String[] arrayStirng = new String[10]; // на печать выведет "null"
        Object[] arrayObject = new String[10]; // на печать выведет "null"
        ArraysBasic arraysBasic = new ArraysBasic(); // int[] arrVoid = new int[10];

        System.out.println(Arrays.toString(arrayInt)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(arrayFloat)); // [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
        System.out.println(Arrays.toString(arrayBool)); // [false, false, false, false, false, false, false, false, false, false]
        System.out.println(Arrays.toString(arrayStirng)); // [null, null, null, null, null, null, null, null, null, null]
        System.out.println(Arrays.toString(arrayObject) + "\n"); // [null, null, null, null, null, null, null, null, null, null]

        // проверка присвоения из нестатического контестка через объекты
        System.out.println(Arrays.toString(arraysBasic.arrVoid)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(arraysBasic.arrDinamic)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(arraysBasic.arrDinamic2)); // [6, 7, 8, 9, 10]
        System.out.println(Arrays.toString(arraysBasic.i)); // [1, 2, 3]
        System.out.println(Arrays.deepToString(arraysBasic.c)); // [[1, 2], [7, 3]]
    }
}