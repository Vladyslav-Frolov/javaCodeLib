package info.vladyslav.javabasics.u01core.core_07_lambda;

public class Lambda02Advance {
    public static void main(String[] args) {
        MyAdvancedNumber number = () -> 115.5;

        System.out.println("Functional method: " + number.getNumber());
        number.doSomethingByDefault();
        MyAdvancedNumber.doSomethingByStatic();
    }
}

@FunctionalInterface
interface MyAdvancedNumber {

    double getNumber(); // функциональный метод, должен быть один на интерфейс

    default void doSomethingByDefault() { // дефолтный метод
        System.out.println("Default method in functional interface");
    }

    static void doSomethingByStatic() { // статический метод
        System.out.println("Static method in functional interface");
    }
}