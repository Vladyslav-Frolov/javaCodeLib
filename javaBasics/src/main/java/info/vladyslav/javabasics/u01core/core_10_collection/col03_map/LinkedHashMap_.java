package info.vladyslav.javabasics.u01core.core_10_collection.col03_map;

import java.util.LinkedHashMap;

public class LinkedHashMap_ {
    public static void main(String[] args) {
        LinkedHashMap<String, String> stringLinkedHashMap = new LinkedHashMap<>();
        stringLinkedHashMap.put("test", "example");

        System.out.println(stringLinkedHashMap);
    }
}
