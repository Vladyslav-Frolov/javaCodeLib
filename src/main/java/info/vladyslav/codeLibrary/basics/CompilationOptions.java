package info.vladyslav.codeLibrary.basics;

public class CompilationOptions {
    int i = 10;
    static int b = 30;
    public CompilationOptions() {
        this.i = 20;
    }

    // компилируется даже если имя аргумента не "args"
    public static void main(String[] argv){
        System.out.println("test");
    }
}

