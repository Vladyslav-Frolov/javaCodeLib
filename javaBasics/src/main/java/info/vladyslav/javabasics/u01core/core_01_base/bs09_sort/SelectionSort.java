package info.vladyslav.javabasics.u01core.core_01_base.bs09_sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 2, 1, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];//Предположительно минималтьный элемент
            int imin = i;//Предположительно индекс минимально элемента
            for (int j = i + 1; j < arr.length; j++) {
                //Если находим минимум, то мы запоминаем его индекс
                //И обновляем значение минимума
                if (arr[j] < min) {
                    min = arr[j];
                    imin = j;
                }
            }
            //Нашелся ли элемент который меньше чем тот который стоит на данной позиции.
            //Если нашелся, то меняем элементы местами
            if (i != imin) {
                int temp = arr[i];
                arr[i] = arr[imin];
                arr[imin] = temp;
            }
            System.out.println(arr[i] + " ");
        }
    }
}
