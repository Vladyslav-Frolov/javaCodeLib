package info.vladyslav.cl.javaBasics.y_epam2.epam08_1_screening;

public class Screening3 {

}

class Coffee {
    enum CoffeeSize {BIG, HUGE, OVERWHELMING}

    CoffeeSize size;
}

class Test {
    public static void main(String[] args) {
        Coffee drink = new Coffee();
//        drink.size = CoffeeSize.BIG;
        System.out.println(drink.size);
    }
}
/**
 * What will be the result of the following code:
 * Runtime error
 * null
 * BIG
 * Compilation error <-- correct
 */