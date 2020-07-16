package info.vladyslav.codeLibrary.basics.strings;

public class StringCompare {
    public static void main(String[] args) {
        String s1 = "String"; // находится в пуле литералов
        String s2 = new String ("String"); // находится в куче
        System.out.println(s1.compareTo(s2)); // 0 → объекты равны // <-> → объект на котором вызвано сравнение предшествует строке переданной в аргумент
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s2.intern()); // true // .intern() переводит объект из кучи в пул литералов
    }
}
