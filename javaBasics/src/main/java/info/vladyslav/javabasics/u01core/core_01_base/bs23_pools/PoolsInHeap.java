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
        System.out.println("---------------------");

        Double d = 0.1;
        Double d2 = 0.1;
        System.out.println(d == d2); // false

        Float f = 0.1f;
        Float f2 = 0.1f;
        System.out.println(d == d2); // false

        System.out.println("=======================");
        Byte bb = 1;
        Byte bb2 = 1;
        System.out.println(bb == bb2); // true

        Byte bb3 = 127;
        Byte bb4 = 127;
        System.out.println(bb3 == bb4); // true

        Short sort1 = 1;
        Short sort2 = 1;
        System.out.println(sort1 == sort2); // true

        Short sort3 = 10000;
        Short sort4 = 10000;
        System.out.println(sort3 == sort4); // false

        Long l1 = 1L;
        Long l2 = 1L;
        System.out.println(l1 == l2); // true

        Long l3 = 10000L;
        Long l4 = 10000L;
        System.out.println(l3 == l4); // false
        System.out.println("------------============");

        Character c = 1;
        Character c2 = 1;

        System.out.println(c == c2); // true

        Character c3 = 60000;
        Character c4 = 60000;

        System.out.println(c3 == c4); // false
    }
}
