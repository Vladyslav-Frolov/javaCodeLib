package info.vladyslav.codeLibrary.basics;

import java.util.Arrays;

public class BabbleSort {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 0};

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;    }}}

        System.out.println(Arrays.toString(arr));
    }


}
