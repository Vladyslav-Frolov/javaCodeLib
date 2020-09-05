package info.vladyslav.codeLibrary.u01core.core_01_base;

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
        show.show("Test ", 123, " ", 'D', 'o', 'n', 'e', ' ', true); // Test 123 Done true

        show.print("Test " + 123 + " " + 'D' + 'o' + 'n' + 'e' + ' ' + true);

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

    // тоже самое, что и выше, но локаничнее код без VarArgs
    // и передавать аргументы надо будет через "+", а не через ",", т. е. конкатенировать
    void print(Object text) {
        System.out.println(text);
    }
}
