package Stream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class concurrentHashMap {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();



        map.put("a", 1);
        map.put("b", 2);

        for(Map.Entry<String,Integer> entry : map.entrySet()){

            System.out.println(entry.getKey() + " " + entry.getValue());

        }

        map.put("a", null);

        for(Map.Entry<String,Integer> entry : map.entrySet()){

            System.out.println(entry.getKey() + " " + entry.getKey());

        }

        /*

        ConcurrentHashMap dosnt allow null keys, values
        because it creates ambguity
        "a" is not in the map
        "a" is in the map but its value is null
        This is already bad in single-threaded code, but disastrous in concurrency.

        Why Tree-based collections don’t allow nulls?
        Because:

TreeSet / TreeMap rely on compareTo() or Comparator

null cannot be compared


ConcurrentHashMap does not allow null keys or values to avoid ambiguity during concurrent access.
When get(key) returns null, it becomes unclear whether the key is absent or the key exists with a null value.
In a multithreaded environment with mostly lock-free reads, this ambiguity can lead to incorrect assumptions and race conditions.
Disallowing null ensures predictable behavior and simplifies concurrent read/write guarantees.

         */







    }
}
