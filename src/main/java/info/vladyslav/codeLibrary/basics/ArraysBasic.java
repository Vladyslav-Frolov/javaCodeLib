package info.vladyslav.codeLibrary.basics;

import java.util.Arrays;

public class ArraysBasic {
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
        c = new int[][]{{1, 2},{1,3}};
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

        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayFloat));
        System.out.println(Arrays.toString(arrayBool));
        System.out.println(Arrays.toString(arrayStirng));
    }
}
