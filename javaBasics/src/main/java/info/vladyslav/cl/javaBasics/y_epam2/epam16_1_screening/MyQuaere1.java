package info.vladyslav.cl.javaBasics.y_epam2.epam16_1_screening;

import java.util.ArrayList;

public class MyQuaere1 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("apple");
        myList.add("carrot");
        myList.add("banana");
        myList.add(1, "plum");
        System.out.println(myList);
    }
}
/**
 * What will be the result of the following code?
 * <p>
 * [apple, banana, carrot, plum]
 * [apple, plum, carrot, banana] <-- correct (I)
 * [plum, apple, carrot, banana]
 * [apple, plum banana, carrot]
 * [plum, banana, carrot, apple]
 */