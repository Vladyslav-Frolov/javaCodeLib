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
    }
}
