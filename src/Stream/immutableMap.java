package Stream;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class immutableMap {
    public static void main(String[] args) {
        Map<String, Integer> mutable = new HashMap<>();
        mutable.put("one", 1);
        mutable.put("two" , 2);
        mutable.put("three", 3);
        Map<String,Integer> immutableMap = Collections.unmodifiableMap(mutable);

        immutableMap.put("four", 4);

        /*
        Even though unmodifiable cannot be modified directly, changes made to the original mutable map are reflected.
        Key point:
        Wrapper around an existing map.
        Original map can still change.
        Changes in original map are visible through the unmodifiable view.
         */

        Map<String, Integer> newImmutableMap = Map.of("1",1,"2", 2, "3", 3);
        System.out.println(newImmutableMap);
        newImmutableMap.put("5",5);

        /*
        Map.of
        Key point:
        Immutable map implementation.
        No underlying mutable map.
        Contents never change after creation.
         */


    }
}
