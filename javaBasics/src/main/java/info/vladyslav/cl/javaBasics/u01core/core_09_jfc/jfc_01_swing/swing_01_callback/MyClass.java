package info.vladyslav.cl.javaBasics.u01core.core_09_jfc.jfc_01_swing.swing_01_callback;

public class MyClass implements SomeClass.Callback {
    @Override
    public void callingBack() {
        System.out.println("Вызов метода обратного вызова");
    }
}
