package Heap;

import java.util.*;

public class FrequencySortArray {

    public static int[] frequencySort(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        List<Integer> result = new ArrayList<>();

        while(!pq.isEmpty()){

            int num = pq.poll();
            int freq = map.get(num);

            for(int i=0;i<freq;i++){
                result.add(num);
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }

}
