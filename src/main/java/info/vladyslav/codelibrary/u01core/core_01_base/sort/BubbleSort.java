package info.vladyslav.codelibrary.u01core.core_01_base.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        // first bubble sorting method (brute force method)
        int[] arr = {1, -2, 10, 4, 0};

        int iteration = 0; // можно удалять
        int iteration2 = 0; // можно удалять
        int iteration3 = 0; // можно удалять
        for (int i = arr.length - 1; i > 0; i--) {
            iteration++; // можно удалять
            for (int j = 0; j < i; j++) {
                iteration2++; // можно удалять
                if (arr[j] > arr[j + 1]) {
                    iteration3++; // можно удалять
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(iteration);
        System.out.println(iteration2);
        System.out.println(iteration3);
//--------------------------------------------------------------------------------
        // the second way to sort by bubble using a boolean flag
        int[] mas = {1, -2, 10, 4, 0};

        int iteration01 = 0; // можно удалять
        int iteration02 = 0; // можно удалять
        int iteration03 = 0; // можно удалять

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            iteration01++; // можно удалять
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                iteration02++; // можно удалять
                if (mas[i] > mas[i + 1]) {
                    iteration03++; // можно удалять
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));
        System.out.println(iteration01);
        System.out.println(iteration02);
        System.out.println(iteration03);

    }


}
