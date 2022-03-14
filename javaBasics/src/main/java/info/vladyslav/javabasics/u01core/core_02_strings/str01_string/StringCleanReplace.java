package info.vladyslav.javabasics.u01core.core_02_strings.str01_string;

public class StringCleanReplace {
    public static void main(String[] args) {
        String body = "<test>\ntest2\n";
        System.out.println(body);

        body = body.replaceAll(">\n", ">&#10;");
        System.out.println(body);
    }
}
