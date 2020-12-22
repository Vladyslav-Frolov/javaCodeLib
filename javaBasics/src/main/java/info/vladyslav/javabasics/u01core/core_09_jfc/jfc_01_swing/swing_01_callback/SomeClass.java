package info.vladyslav.javabasics.u01core.core_09_jfc.jfc_01_swing.swing_01_callback;

import javax.swing.*;

public class SomeClass {
    // создаем колбек и его метод
    interface Callback{
        void callingBack();
    }

    Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    void doSomething(){
        JOptionPane.showMessageDialog(null, "Выполняется работа");

        // вызываем метод обратного вызова
        callback.callingBack();
    }
}
