package info.vladyslav.cl.javaBasics.u01core.core_01_base.map;

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

class UniqueWordsWithMap2{
    public static void main(String[] args) {
        String sentence = "House, House, House, Dog, Dog, Dog, Dog, House, House, House";
        Map<String, Integer> map = new HashMap<>();
        for(String word : sentence.split(", ")){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        System.out.println(map);
    }
}

