package info.vladyslav.javabasics.u01core.core_01_base.bs09_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int temp, j;
        int iteration = 0; // можно удалять
        int iteration2 = 0; // можно удалять
        int iteration3 = 0; // можно удалять
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                    iteration++; // можно удалять
                }
                arr[j] = temp;
                iteration2++; // можно удалять
            }
            iteration3++; // можно удалять
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(iteration); // можно удалять
        System.out.println(iteration2); // можно удалять
        System.out.println(iteration3); // можно удалять
    }
}
