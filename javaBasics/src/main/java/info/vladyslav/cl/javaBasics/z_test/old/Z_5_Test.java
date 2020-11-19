package info.vladyslav.cl.javaBasics.z_test.old;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Z_5_Test {
    private int i = 1;
    public static long removeByIndex(final List<Integer> list, final int k) {
        long before = System.currentTimeMillis();
        int index = k - 1;

        while (list.size() > 1) {
            while (index < list.size()) {
                list.remove(index);
                index = index + k - 1;
            }
            index = (index - list.size());
        }
        return System.currentTimeMillis() - before;
    }

    public static long removeByIterator(final List<Integer> list, int k) {
        long before = System.currentTimeMillis();
        int index = 0;
        while (list.size() > 1) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                index++;
                it.next();
                if (index == k) {
                    it.remove();
                    index = 0;
                }
            }
        }
        return System.currentTimeMillis() - before;
    }

    public static void main(String[] args) {
        int k = 4;

        List<Integer> array = Stream.iterate(0, x -> x + 1)
                .limit(10_000)
                .collect(Collectors.toCollection(ArrayList::new));

        List<Integer> linked = Stream.iterate(0, x -> x + 1)
                .limit(10_000)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("ArrayList#Index: " + removeByIndex(array, k) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(linked, k) + " ms");


        array = Stream.iterate(0, x -> x + 1)
                .limit(10_000)
                .collect(Collectors.toCollection(ArrayList::new));

        linked = Stream.iterate(0, x -> x + 1)
                .limit(10_000)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("ArrayList#Iterator: " + removeByIterator(array, k) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(linked, k) + " ms");

    }


}
/*
class BB extends Z_5_Test{
    public static void main(String[] args) {
BB test = new BB();
        System.out.println(test.i);
    }
}*/
