package info.vladyslav.javabasics.u01core.core_09_jfc.jfc01_swing.swing_01_callback;

public class MyClass implements SomeClass.Callback {
    @Override
    public void callingBack() {
        System.out.println("Вызов метода обратного вызова");
    }
}
