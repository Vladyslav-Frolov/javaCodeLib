package info.vladyslav.javabasics.u01core.core_01_base.bs23_pools;

public class PoolsInHeap {
    public static void main(String[] args) {
        // Java pool Integers [-128;127]
        Integer i = 100;
        Integer i2 = 100;
        Integer b = 80000000;
        Integer b2 = 80000000;
        System.out.println(i == i2); // true
        System.out.println(b == b2); // false
        System.out.println("--------------");

        // Java pool Strings --> entire
        String s = "test";
        String s2 = "test";

        System.out.println(s == s2); // true

        String s3 = new String("test");
        System.out.println(s == s3); // false

        s3.intern();
        System.out.println(s == s3); // false
        System.out.println(s == s3.intern()); // true

        String s4 = s3;
        System.out.println(s == s4); // false

        String s5 = s4.intern();
        System.out.println(s == s5); // true


    }
}
