package info.vladyslav.codeLibrary.basics.strings;

import java.util.Arrays;

public class StringCreation {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        String s = String.valueOf(sb);
        System.out.println(s); // test

        char[] ch = new char[]{'b', 'c', 'd', 'e', 'f', 'g'};
        String s2 = String.valueOf(ch);
        System.out.println(s2); // bcdefg

        String[] str = new String[]{"b", "c", "d", "e", "f", "g"};
        String s3 = String.valueOf(str); // хеш-код → это какая-то бессмыслица :)
        System.out.println("s3: " + s3); // [Ljava.lang.String;@677327b6
        System.out.println("s3: " + Arrays.toString(str)); // [b, c, d, e, f, g]
        System.out.println("str: " + str); // [Ljava.lang.String;@677327b6

        String s4 = "String"; // находится в пуле литералов
        String s5 = new String ("String"); // находится в куче
        System.out.println(s4.compareTo(s5)); // 0 → объекты равны
        System.out.println(s4.equals(s5)); // true
        System.out.println(s4 == s5); // false
        System.out.println(s4 == s5.intern()); // true // .intern() переводит объект из кучи в пул литералов

    }
}
