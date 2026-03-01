package Stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class concurrentHashMapIterator {
    public static void main(String[] args) {

       ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();

       map.put("ash", 1);
       map.put("tanu", 2);

       Iterator<String> it = map.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next();
            map.remove(key);
        }
    }
}
