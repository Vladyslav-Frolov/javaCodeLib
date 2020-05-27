package info.vladyslav.codeLibrary.basics.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 2, 1, 3, 4};
        int temp, j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
//------------------------------------------------------------
        // 2-й способ с приминением while (но это избыточно)
        boolean sorted = false;
        int temp1;
        int[] array = {5, 6, 8, 9, 2, 1, 3, 4, 99, 10};
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp1 = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp1;
                    sorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
