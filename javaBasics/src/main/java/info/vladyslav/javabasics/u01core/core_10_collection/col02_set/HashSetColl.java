package info.vladyslav.javabasics.u01core.core_10_collection.col02_set;

import java.util.HashSet;

public class HashSetColl {
    HashSet<Object> hashSet = new HashSet<>();
    {
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
    }

    {
        hashSet.remove("2");
    }

    public static void main(String[] args) {
        HashSetColl hashSetColl = new HashSetColl();
        System.out.println(hashSetColl.hashSet);
        System.out.println(hashSetColl.hashSet.size()); // 3
        System.out.println(hashSetColl.hashSet.isEmpty()); // false
        System.out.println(hashSetColl.hashSet.contains("1")); // true
        System.out.println(hashSetColl.hashSet.contains("2")); // false
    }
}
