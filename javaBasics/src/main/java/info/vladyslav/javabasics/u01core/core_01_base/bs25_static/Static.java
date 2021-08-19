package info.vladyslav.javabasics.u01core.core_01_base.bs25_static;

import java.io.Serializable;

public class Static implements Serializable {
    private static final long serialVersionUID = 4308331351481082488L; // private for static
    static long serialVersionUID2;

    static {
        int i;
    }

    public static void main(String[] args) {
        Static aStatic = new Static();
        aStatic.serialVersionUID2 = 10;
        aStatic.serialVersionUID2 = aStatic.serialVersionUID2 + 12;
        System.out.println(Static.serialVersionUID2); // 22
        serialVersionUID2 = 77;
        System.out.println(Static.serialVersionUID2); // 77
    }
}

class StaticTest {
    public static void main(String[] args) {
        Static aStatic = new Static();
        System.out.println(Static.serialVersionUID2); // 0
        aStatic.main(new String[]{""});
        System.out.println(Static.serialVersionUID2); // 77
    }
}