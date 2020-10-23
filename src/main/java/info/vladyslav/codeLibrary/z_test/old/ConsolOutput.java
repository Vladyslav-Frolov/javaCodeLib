package info.vladyslav.codeLibrary.z_test.old;

public class ConsolOutput {
    public static void main(String[] args) {
        // передача в консоль соседнего класса через вызов и исполнение его метода main
        Part.main(new String[]{"--input", "part6.txt", "--task", "frequency"});
    }
}

class Part {
    public static void main(String[] args) {
        // вывод через отдельный метод
        consoleOutput(args[0], args[1], args[2], args[3]);
        // вывод напрямую
        System.out.println(args[0] + " " + args[1] + " " + args[2] + " " + args[3]);
    }

    public static void consoleOutput(String input, String filename, String task, String operation) {
        System.out.println(input + " " + filename + " " + task + " " + operation);
    }
}