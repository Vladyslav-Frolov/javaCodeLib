package info.vladyslav.javabasics.u01core.core_01_base.bs06_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static final String FIND = "Найдено значение: ";

    public static void main(String args[]) {
        String text = "Крещение Руси произошло в 988 году! Не так ли?"; // Строка для сканирования, чтобы найти шаблон
        String regex = "(.*)(\\d+)(.*)"; // регулярное выражение

        Pattern pattern = Pattern.compile(regex); // Создание Pattern объекта

        Matcher matcher = pattern.matcher(text); // Создание matcher объекта

        if (matcher.find()) {
            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
            System.out.println(FIND + matcher.group(0));
            System.out.println(FIND + matcher.group(1));
            System.out.println(FIND + matcher.group(2));
            System.out.println(FIND + matcher.group(3));
        } else {
            System.out.println("НЕ СОВПАДАЕТ");
        }

        outputBindDigits("Крещение Руси произошло в 988 году! Не так ли?"); // 988
        outputBindDigits("Украина обрела независимость в 1991 году"); // 1991
    }

    private static int outputBindDigits(String str1) {
        Matcher matcher = (Pattern.compile("[\\d]{2,}").matcher(str1)); // Паттерн и Матчер одной строкой
        int strInt = 0;
        int endInt = 0;

        if (matcher.find()) { // получаем индексы начала и окончания первого совпадения
            strInt = matcher.start();
            endInt = matcher.end();
        }

        StringBuilder strToDigit = new StringBuilder();
        for (int i = strInt; i < endInt; i++) { // записываем в новый Стринг всю строку первого совпадения через цикл
            strToDigit.append(str1.charAt(i));
        }

        int digit = Integer.parseInt(strToDigit.toString()); // конвертируем Стринг в Инт
        System.out.println("Number is: " + digit);
        return digit;
    }
}
