package info.vladyslav.cl.javaBasics.u01core.core_02_strings.str01string;

import java.util.Arrays;

public class StringPopMethods {
    public static void main(String[] args) {
        String s1 = "String"; // находится в пуле литералов
        String s2 = new String ("String"); // находится в куче

        System.out.println(s1.charAt(2)); // r // "String" → 2 → r
        System.out.println(s1.codePointAt(2)); // 114 → кодовая точка по определённому индексу
        System.out.println(s1.substring(2)); // ring
        System.out.println(s1.substring(2,4)); // ri

        String s3 = "Forever";
        String s4 = "Forever Forever";
        System.out.println(s3.replace("e", "t")); // Forever → Fortvtr
        System.out.println(s3.replace("For", "PPP")); // Fortvtr → PPPever
        System.out.println(s4.replace("For", "PPP")); // Forever Forever → PPPever PPPever

        String[] sArr = s4.split(" ");
        System.out.println(Arrays.toString(sArr)); // [Forever, Forever]

        String s5 = "Forever Forever Forever Forever Forever";
        String[] sArr2 = s5.split(" ", 3);
        System.out.println(Arrays.toString(sArr2)); // [Forever, Forever, Forever Forever Forever]

        double i = 654684.74654968;
        String s6 = s5.valueOf(i);
        String s7 = "";
        s7 = s7.valueOf(i);
        System.out.println(s6); // 654684.74654968
        System.out.println(s7); // 654684.74654968
    }
}
