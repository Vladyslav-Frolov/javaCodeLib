package info.vladyslav.codeLibrary.u01core.core_09_jfc.jfc_01_swing.swing_01_callback;

public class Main {
    public static void main(String[] args) {

        SomeClass someClass = new SomeClass();
        MyClass myClass = new MyClass();

        someClass.registerCallBack(myClass);
        someClass.doSomething();
    }
}
