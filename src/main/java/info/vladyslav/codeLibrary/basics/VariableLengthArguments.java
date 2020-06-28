package info.vladyslav.codeLibrary.basics;

public class VariableLengthArguments {

    public static void main(String[] args) {
        int sum;
        sum = SumParams(1, 3, -2, 4, 8); // sum = 14
        System.out.println(sum);

        sum = SumParams(); // sum = 0
        System.out.println(sum);

        sum = SumParams(1, 2, 3); // sum = 6
        System.out.println(sum);

    }

    static int SumParams(int ... T) {
        int sum = 0;
        for (int i=0; i<T.length; i++)
            sum += T[i];
        return sum;
    }
}
