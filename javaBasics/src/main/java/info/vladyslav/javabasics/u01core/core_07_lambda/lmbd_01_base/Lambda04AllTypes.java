package info.vladyslav.javabasics.u01core.core_07_lambda.lmbd_01_base;

public class Lambda04AllTypes {
    public static void main(String[] args) {
/*        Consumer consumer = (x) -> {
            double result = (double) x / 3;
            System.out.println(result);
        };
        consumer.accept(10.);*/

        res(10, System.out::println);

    }

    static void res(int i, Consumer c) {
        c.accept(i);
    }


}

// 1
interface Consumer<T> {
    void accept(T t);
}

// 2
interface Supplier<T> {
    T get();
}

// 3
interface Predicate<T> {
    boolean test(T t);
}

// 4
interface BinaryOperator<T> {
    T apply(T t1, T t2);
}

//5
interface UnaryOperator<T> {
    T apply(T t);
}

// 6
interface Function<T, R> {
    R apply(T t);
}
