package info.vladyslav.javabasics.u01core.core_07_lambda;

public class Lambda03Block {
    public static void main(String[] args) {
        NumericFunc factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println("Факториал числа 3 равен " + factorial.func(3)); // Факториал числа 3 равен 6
        System.out.println("Факториал числа 5 равен " + factorial.func(5)); // Факториал числа 5 равен 120
    }
}


interface NumericFunc {
    int func(int n);
}
