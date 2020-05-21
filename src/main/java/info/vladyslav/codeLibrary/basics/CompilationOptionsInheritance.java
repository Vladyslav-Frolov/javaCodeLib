package info.vladyslav.codeLibrary.basics;

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
