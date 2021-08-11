package info.vladyslav.javabasics.u01core.core_10_collection.col02_set;

import java.util.HashSet;

public class HashSet_2 {
    public static void main(String[] args) {
        HashSet<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        integerSet.add(5);
        integerSet.add(6);
        integerSet.add(6);
        integerSet.add(6);
        integerSet.add(7);
        integerSet.add(8);
        integerSet.add(9);
        integerSet.add(10);
        integerSet.add(11);
        integerSet.add(null);
        System.out.println(integerSet);

    }
}
