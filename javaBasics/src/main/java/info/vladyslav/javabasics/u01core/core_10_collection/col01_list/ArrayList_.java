package info.vladyslav.javabasics.u01core.core_10_collection.col01_list;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_ {
    public static void main(String[] args) {
        List<Object> listItems = new ArrayList<>();
        int num = 0;

        listItems.add(++num);
        listItems.add(++num);
        listItems.add(++num);
        listItems.add(++num);
        System.out.println(listItems);
        System.out.println("get index 0 --> " + listItems.get(0));
        System.out.println("get index 1 --> " + listItems.get(1));
        System.out.println("get index 2 --> " + listItems.get(2));
        System.out.println("get index 3 --> " + listItems.get(3));
        System.out.println("set index 0 --> " + listItems.set(1, 10));

        System.out.println("get index 0 --> " + listItems.get(0));
        System.out.println("get index 1 --> " + listItems.get(1));
        System.out.println("get index 2 --> " + listItems.get(2));
        System.out.println("get index 3 --> " + listItems.get(3));

    }
}
