package info.vladyslav.codeLibrary.basics;

public class InitializationVariables {
    // нестатический контекст
    // объявление имён
    int a, b, c, d, e, f;

    // будет ошибка компиляции,
    // a = 10;
    /**
     * присвоить не в статическом контексте, если переменная уже объявлена,
     * можно только через конструктор
     */

    // объявление с динамическим присвоением
    int a1 = 1, b1 = 2, c1 = 3, d1 = 4;


    public static void main(String[] args) {

    }


}
