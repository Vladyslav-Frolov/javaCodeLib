package info.vladyslav.javabasics.u01core.core_10_collection.col01_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayList_ {
    public static void main(String[] args) {
        List<Integer> listItems = new ArrayList<>();
        int num = 0;

        listItems.add(++num);
        listItems.add(++num);
        listItems.add(++num);
        listItems.add(++num);
        System.out.println(listItems); // [1, 2, 3, 4]
        System.out.println("get index 0 --> " + listItems.get(0)); // get index 0 --> 1
        System.out.println("get index 1 --> " + listItems.get(1));
        System.out.println("get index 2 --> " + listItems.get(2));
        System.out.println("get index 3 --> " + listItems.get(3));
        System.out.println("set index 0 --> " + listItems.set(1, 10));

        System.out.println("get index 0 --> " + listItems.get(0));
        System.out.println("get index 1 --> " + listItems.get(1));
        System.out.println("get index 2 --> " + listItems.get(2));
        System.out.println("get index 3 --> " + listItems.get(3));
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println(listItems);

        Collections.sort(listItems);
        System.out.println(listItems); // [1, 3, 4, 10]

        System.out.println("---------------------------");
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list); // [one, two, three, four]

        list.sort(Comparator.comparing(Object::toString));
        System.out.println(list); // [four, one, three, two]

        list.sort(Comparator.reverseOrder());
        System.out.println(list); // [two, three, one, four]

    }
}
