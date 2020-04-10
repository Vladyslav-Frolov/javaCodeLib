package info.vladyslav.codeLibrary.basics;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        // first bubble sorting method (brute force method)
        int[] arr = {1, -2, 10, 4, 0};

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;    }}}

        System.out.println(Arrays.toString(arr));

        // the second way to sort by bubble using a boolean flag (less expensive)
        int [] mas = {11, 3, 14, 16, 7};

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));

    }


}
