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

        VariableLengthArguments show = new VariableLengthArguments();
        show.show("Test ", 123, " ", 'D', 'o', 'n', 'e',' ', true); // Test 123 Done true

    }

    // сложение множественных аргументов
    static int SumParams(int... T) {
        int sum = 0;
        for (int i = 0; i < T.length; i++)
            sum += T[i];
        return sum;
    }

    // для вывода чего угодно на печать, кроме объектов без ту стринг, массивов и всего того, что просто так не выводится
    void show(Object... objects) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < objects.length; i++)
            text.append(objects[i]);

        System.out.print(text);
    }
}
