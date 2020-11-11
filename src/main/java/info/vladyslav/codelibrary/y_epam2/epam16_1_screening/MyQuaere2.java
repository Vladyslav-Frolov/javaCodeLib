package info.vladyslav.codelibrary.y_epam2.epam16_1_screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyQuaere2 {
    private static List<String> sort(List<String> list) {
//        List<String> copy = new ArrayList<>(list);
//        Collections.sort(copy, (a, b) -> b.compareTo(a));
//        return copy;
        return list.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
        list = sort(list);
        System.out.println(list);


    }
}
/**
 * Which of the following can replace implementation of sort() method
 * to do the same through streams (a sort() method
 * returns a sorted list without the original)?
 *
 * return list.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList()); <-- correct
 * return list.stream().sorted((a, b) -> b.compareTo(a)).collect();
 * return list.stream().compare((a, b) -> b.compareTo(a)).collect(Collctors.toList()); (I)
 * return list.stream().compareTo((a, b) -> b.compareTo(a)).sort();
 * return list.stream().compareTo((a, b) -> b.compareTo(a)).collect(Collectors.toList());
 */