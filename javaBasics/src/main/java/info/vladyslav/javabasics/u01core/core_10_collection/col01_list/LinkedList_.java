package info.vladyslav.javabasics.u01core.core_10_collection.col01_list;

import java.util.Comparator;
import java.util.LinkedList;

public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("thee");
        linkedList.add("four");

        System.out.println(linkedList); // [one, two, thee, four]

        System.out.println(linkedList.get(1)); // two

        linkedList.remove(1);
        System.out.println(linkedList); // [one, thee, four]

        linkedList.remove(1); // [one, four]
        System.out.println(linkedList);

        System.out.println("=====================");
        linkedList.remove();
        System.out.println(linkedList); // [four]

        linkedList.remove();
        System.out.println(linkedList); // []
        System.out.println("=====================");

        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("thee");
        linkedList.add("four");

        System.out.println(linkedList.getFirst()); // one
        System.out.println(linkedList.getLast()); // four

        System.out.println("===========----------------");
        System.out.println(linkedList); // [one, two, thee, four]
        linkedList.sort(Comparator.reverseOrder());
        System.out.println(linkedList); // [two, thee, one, four]
        linkedList.sort(Comparator.naturalOrder());
        System.out.println(linkedList); // [four, one, thee, two]

        System.out.println("****************************");
        LinkedList<Object> linkedList2 = new LinkedList<>();
        linkedList2.add("one");
        linkedList2.add("two");
        linkedList2.add("thee");
        linkedList2.add("four");
        System.out.println(linkedList2);

        linkedList2.sort(Comparator.comparing(Object::toString));
        System.out.println(linkedList2); // [four, one, thee, two]
        linkedList2.sort(Comparator.comparing(Object::toString).reversed());
        System.out.println(linkedList2); // [two, thee, one, four]

    }
}
