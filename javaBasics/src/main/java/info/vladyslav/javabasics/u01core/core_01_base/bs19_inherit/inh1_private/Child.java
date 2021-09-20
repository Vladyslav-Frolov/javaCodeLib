package info.vladyslav.javabasics.u01core.core_01_base.bs19_inherit.inh1_private;

public class Child extends Parent {
    int i = 2; // hide parent field

    public static void main(String[] args) {
        Child child = new Child();
        child.print(); // 1
    }

}
