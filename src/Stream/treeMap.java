package Stream;

import java.util.Map;
import java.util.TreeMap;

public class treeMap {
    public static void main(String[] args) {

        TreeMap<Integer,Integer> map1 = new TreeMap<>();

        map1.put(1,10);
        map1.put(2,20);
        map1.put(3,30);

        TreeMap<Integer,Integer> map2 = new TreeMap<>();
        map2.put(2,15);
        map2.put(3,25);
        map2.put(4,40);

        for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(map1.containsKey(key)){
                map1.put(key, map1.get(key)+value);
            }else{
                map1.put(key, value);
            }
        }
        System.out.println(map1);
    }
}
