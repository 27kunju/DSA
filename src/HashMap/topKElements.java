package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKElements {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));

        maxHeap.addAll(freqMap.keySet());

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
