package info.vladyslav.cl.javaBasics.z_test.old;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Z_3_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keyAndLocal = "";
        Pattern pattern = Pattern.compile("(\\b\\w+\\b)");
        keyAndLocal = sc.nextLine();
        System.out.println(keyAndLocal);
        Matcher matcher = pattern.matcher(keyAndLocal);
        matcher.find();
        System.out.println(matcher.group());
    }
}
