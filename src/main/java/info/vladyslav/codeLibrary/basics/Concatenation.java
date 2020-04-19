package info.vladyslav.codeLibrary.basics;

public class Concatenation {
    public static void main(String[] args) {
        String a = "java " + 2 + 2; // java 22
        String b = 2 + 2 + " java " + 2 + 2; // 4 java 22
        String c = 2 + 2 + " java " + (2 + 2); // 4 java 4
        String d = (2 + 2) + " java"; // 4 java
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
