package info.vladyslav.javabasics.u01core.core_10_collection.col03_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class GeneralMap {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Object, Object> treeMap = new TreeMap<>();

        hashMap.put("1", 1);
        hashMap.putIfAbsent("1", 2100000);
        hashMap.putIfAbsent("2", 1);
        hashMap.putIfAbsent("2", 2); // exist means skip
        System.out.println(hashMap); // {1=1, 2=1}
        hashMap.put("1", 2100000);
        System.out.println(hashMap); // {1=2100000, 2=1}
        System.out.println(hashMap.containsKey("1")); // true
        System.out.println(hashMap.containsKey(1)); // false
        System.out.println(hashMap.containsValue(1)); // true

    }
}
