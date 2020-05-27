package info.vladyslav.codeLibrary.basics.sort;

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

//------------------------------------------------------------
        // 2-й способ, while снаружи (затранее, чем первый вариант)
        boolean sorted = false;
        int[] array = {5, 4, 3, 2, 1};
        int temp1;
        int iteration01 = 0; // можно удалять
        int iteration02 = 0; // можно удалять
        int iteration03 = 0; // можно удалять
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp1 = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp1;
                    sorted = false;
                    iteration01++;
                }
                iteration02++;
            }
            iteration03++;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(iteration01); // можно удалять
        System.out.println(iteration02); // можно удалять
        System.out.println(iteration03); // можно удалять
    }
}
