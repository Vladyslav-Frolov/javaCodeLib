package info.vladyslav.codelibrary.y_epam2.epam16_1_screening;

import java.util.HashMap;
import java.util.Set;

public class MyQuaere6 {

}

class Test11{
    public static void main(String[] args) {
        HashMap props = new HashMap();
        props.put("key45", "some value");
        props.put("key12", "some other value");
        props.put("key39", "some another value");
        Set s = props.keySet();
        //Line1
    }
}
/**
 * What, inserted at //Line1, will sort the keys in the props HashMap?
 *
 * s = new TreeSet(s) <-- correct (I)
 * s = new SortedSet(s)
 * Collections.sort(s)
 * None of the above
 */