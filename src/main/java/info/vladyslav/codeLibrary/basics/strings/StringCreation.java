package info.vladyslav.codeLibrary.basics.strings;

import java.util.Arrays;

public class StringCreation {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        String s = String.valueOf(sb);

        char [] ch = new char[]{'b', 'c', 'd', 'e', 'f', 'g'};
        String s2 = String.valueOf(ch);

        String [] str = new String[]{"b", "c", "d", "e", "f", "g"};
        String s3 = String.valueOf(str); // хеш-код

        System.out.println(s); // test
        System.out.println(s2); // bcdefg
        System.out.println(s3); // [Ljava.lang.String;@677327b6
    }
}
