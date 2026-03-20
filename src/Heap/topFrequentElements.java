package Heap;

import java.util.*;



public class topFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        for (int key : freqMap.keySet()) {
            minHeap.add(key);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }

    public static int[] topKFrequent2(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        for (int key : freqMap.keySet()) {
            minHeap.add(key);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Build result array
        int[] result = new int[k];
        int i = 0;

        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(topKFrequent(nums, k));
    }
}
