package info.vladyslav.codeLibrary.basics;

public class Equals {
    public static void main(String[] args) {
        String a = "java";
        String b = new String("java");
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
