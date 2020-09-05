package info.vladyslav.codeLibrary.u01core.core_08_stream;

import java.util.ArrayList;

public class Stream01Test {
    public static void main(String[] args) {
        ArrayList<Integer> collection = new ArrayList<Integer>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);

        Integer sumOddOld = 0;
        for(Integer i: collection) {
            if(i % 2 != 0) {
                sumOddOld += i;
            }
        }
        System.out.println(sumOddOld); // 9

        Integer sumOdd = collection
                .parallelStream()
                .filter(o -> o % 2 != 0)
                .reduce((s1, s2) -> s1 + s2)
                .orElse(0);
        System.out.println(sumOdd); // 9
    }
}
