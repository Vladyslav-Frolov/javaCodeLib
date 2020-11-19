package info.vladyslav.cl.javaBasics.y_epam2.epam16_1_screening;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScreeningTest4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 3);
        list.remove(2);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
/**
 * IndexOutOfBoundsException
 * т. к. надо ложить под индексом 0, а не под индексом 1
 */
