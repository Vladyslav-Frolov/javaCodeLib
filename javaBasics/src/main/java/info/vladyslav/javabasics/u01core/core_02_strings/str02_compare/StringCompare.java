package info.vladyslav.javabasics.u01core.core_02_strings.str02_compare;

public class StringCompare {
    public static void main(String[] args) {
        String s1 = "String"; // находится в пуле литералов
        String s2 = new String("String"); // находится в куче
        String s3 = new String("String"); // находится в куче

        System.out.println(s2 == s3); // false → Объекты из кучи нельзя сравнивать обычным сравнением, только equals
        System.out.println(s2.equals(s3)); // true

        System.out.println("----------");
        System.out.println(s1.compareTo(s2)); // 0 → объекты равны // <-> → объект на котором вызвано сравнение предшествует строке переданной в аргумент
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s2.intern()); // true // .intern() переводит объект из кучи в пул литералов
        System.out.println("----------");
        System.out.println("A".compareTo("a")); // -32
        System.out.println("A".compareToIgnoreCase("a")); // 0
        System.out.println("----------");
        System.out.println("A".equals("a")); // false
        System.out.println("A".equalsIgnoreCase("a")); // true
        System.out.println("----------");
        StringBuilder sb = new StringBuilder("A");
        System.out.println("A".equals(sb)); //false
        System.out.println("A".contentEquals(sb)); //true
        System.out.println("----------");
        String ss1 = new String("hello").intern();
        String ss2 = new String("hello").intern();

        System.out.print("ss --> ");
        System.out.println(ss1 == ss2); //true
    }
}
