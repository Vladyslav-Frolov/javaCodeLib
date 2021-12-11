package info.vladyslav.javabasics.u01core.core_10_collection.col02_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSet_Unmodifiable {
//    Set<String> stringSet = Set.of("a", "b", "c"); // Unmodifiable

    /*
    {
        stringSet.add("d"); // UnsupportedOperationException because Unmodifiable
    }
    */

    {
/*        stringSet = new HashSet<>(Arrays.asList("d", "e", "f", "g")); // override all collection also Unmodifiable
        stringSet.add("h"); // add one element*/
    }

    //----------------------------------
/*    public static void main(String[] args) {
        HashSet_Unmodifiable hashSet = new HashSet_Unmodifiable();

        System.out.println(hashSet.stringSet); // [d, e, f, g, h]
    }*/

}
