package info.vladyslav.codeLibrary.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main( String args[] ) {
        String str = "Крещение Руси произошло в 988 году! Не так ли?"; // Строка для сканирования, чтобы найти шаблон
        String regex = "(.*)(\\d+)(.*)"; // регулярное выражение

        Pattern pattern = Pattern.compile(regex); // Создание Pattern объекта

        Matcher matcher = pattern.matcher(str); // Создание matcher объекта

        if (matcher.find( )) {
            System.out.println("Найдено значение: " + matcher.group(0));
            System.out.println("Найдено значение: " + matcher.group(1));
            System.out.println("Найдено значение: " + matcher.group(2));
            System.out.println("Найдено значение: " + matcher.group());
        }else {
            System.out.println("НЕ СОВПАДАЕТ");
        }
    }
}
