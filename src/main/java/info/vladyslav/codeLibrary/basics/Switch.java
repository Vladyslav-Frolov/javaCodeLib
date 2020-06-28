package info.vladyslav.codeLibrary.basics;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        int month = 1;
        String monthString;

// если нужно добавить сканер, то раскоментируйте код ниже
//        Scanner scanner = new Scanner(System.in);
//        month = scanner.nextInt();

        switch (month) {
            case 1:
                monthString = "Январь";
                break;
            case 2:
                monthString = "Февраль";
                break;
            default:
                monthString = "Не знаем такого";
                break;
        }
        System.out.println(monthString);
//-----------------------------------------------------------------
        /**особенные случаи в switch*/

        // default не в конце и у него нет брейка, программа сработает если провалится в деволт, но т. к. нет брейка
        // то выведет следующий case после дефолта
        int i = 4;
        switch (i) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            default:
                System.out.println("None"); // выведется
            case 3:
                System.out.println("Three"); // выведется
                break;
        }

        // можно указывать на 2 разных кейса один и тот же результат следующим образом (пример с 3 и 4)
        int x = 3;
        switch (x) {
            default:
                System.out.println("AAA");
            case 2:
                System.out.println(2);
                break;
            case 3:
            case 4:
                System.out.println("3 or 4");
                break;
        }

    }
}
