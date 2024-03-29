package info.vladyslav.javabasics.u01core.core_01_base.bs12_compile;

public class CompilationOptions {
    int i = 10;
    static int b = 30;

    public CompilationOptions() {
        this.i = 20;
    }

    // компилируется даже если имя аргумента в классе main не "args"
    public static void main(String[] argv) {
        System.out.println("test");
    }
}

class CompilationOptionsInheritance extends CompilationOptions {
    public static void main(String[] args) {
        // компиляйя успешна, т. к. в конструкторе по умолчанию к "i" присваивается 20
        CompilationOptionsInheritance in = new CompilationOptionsInheritance();
        System.out.println(in.i); // 20

        // Errors occurred while compiling module 'code-library-Vladyslav'
        //        System.out.println(CompilationOptionsInheritance.i);

        //компиляция успешна, т. к. статический контекст
        System.out.println(CompilationOptions.b); // 30
    }
}


