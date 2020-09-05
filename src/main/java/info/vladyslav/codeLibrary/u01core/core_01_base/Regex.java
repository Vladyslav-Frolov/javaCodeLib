package info.vladyslav.codeLibrary.u01core.core_01_base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String args[]) {
        // Текст в котором будет производится поиск
        String text = "Крещение Руси произошло в 988 году! А может быть в 1988?";
        // регулярное выражение для поиска
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end());
            System.out.println(" Найдено значение: " + matcher.group());

            // ручаня настройка групп вывода
            System.out.println(" Ручная настройка групп: " + matcher.group(0));

            // второй способ показать результат подстроки
            System.out.println(" Второй способ показать результат подстроки: " +
                    text.substring(matcher.start(), matcher.end()));
        }

        // Проверка если вдруг нет никаких совпадений
        Matcher matcherIfNoMatches = pattern.matcher(text);

        if (matcherIfNoMatches.find()) {
        } else {
            System.out.println("НЕТ СОВПАДЕНИЙ");
        }

        //-----------------------------------------------------------------------------
        // Второй тип создания матчера и паттерна в одну строку
        Matcher matcher2 = Pattern.compile(regex).matcher(text);

        while (matcher2.find()) {
            System.out.print("Start index: " + matcher2.start());
            System.out.print(" End index: " + matcher2.end());
            System.out.println(" Найдено значение: " + matcher2.group());
        }
    }
}
