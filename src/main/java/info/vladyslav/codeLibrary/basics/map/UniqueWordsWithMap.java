package info.vladyslav.codeLibrary.basics.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueWordsWithMap {
    public static void main(String[] args) {
        String s = "House, House, House, Dog, Dog, Dog, Dog, House, House, House";
        String[] str;
        str = s.split(", ");
        System.out.println(Arrays.toString(str));
        Map<String, Integer> occurrences = new HashMap<String, Integer>();
        for (String word : str) {
            Integer oldCount = occurrences.get(word);
            System.out.print(oldCount + " ");
            if ( oldCount == null ) {
                oldCount = 0;
            }
//            System.out.print(oldCount + " ");
            occurrences.put(word, oldCount + 1);

//            System.out.println(oldCount);
//            System.out.println(occurrences);
        }
        System.out.println();
        System.out.println(occurrences);
    }

}
