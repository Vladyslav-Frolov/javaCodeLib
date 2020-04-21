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
