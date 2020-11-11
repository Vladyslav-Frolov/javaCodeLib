package info.vladyslav.codelibrary.u01core.core_01_base;

public class Equals {
    public static void main(String[] args) {
        String a = "java";
        String b = new String("java");

        // так сравниваются только примитивные типы данных, а не ссылочные (объектные), ответ всегда false
        System.out.println(a==b);

        // ссылочные типы ставниваются через метод класса Object
        System.out.println(a.equals(b));
    }
}
