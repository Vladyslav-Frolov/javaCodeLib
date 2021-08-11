package info.vladyslav.javabasics.u01core.core_10_collection.col02_set;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
    Set<Object> hashSet = new HashSet<>();
    {
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
    }

    {
        hashSet.remove("2");
    }

    //----------------------------------
    public static void main(String[] args) {
        HashSet_ hashSet = new HashSet_();
        System.out.println(hashSet.hashSet); // [1, 3, 4]
        System.out.println(hashSet.hashSet.size()); // 3
        System.out.println(hashSet.hashSet.isEmpty()); // false
        System.out.println(hashSet.hashSet.contains("1")); // true
        System.out.println(hashSet.hashSet.contains("2")); // false
        System.out.println(hashSet.hashSet);  // [1, 3, 4]
    }



}
