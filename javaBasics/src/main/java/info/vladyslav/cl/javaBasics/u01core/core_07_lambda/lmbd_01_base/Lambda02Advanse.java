package info.vladyslav.cl.javaBasics.u01core.core_07_lambda.lmbd_01_base;

public class Lambda02Advanse {
    public static void main(String[] args) {
        MyAdvansedNumber number = () -> 115.5;

        System.out.println("Functional method: " + number.getNamber());
        number.doSomethingByDefault();
        MyAdvansedNumber.doSomethingByStatic();
    }
}

@FunctionalInterface
interface MyAdvansedNumber {

    double getNamber(); // функциональный метод, должен быть один на интерфейс

    default void doSomethingByDefault() { // дефолтный метод
        System.out.println("Default method in functional interface");
    }

    static void doSomethingByStatic() { // статический метод
        System.out.println("Static method in functional interface");
    }
}