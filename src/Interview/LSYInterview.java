package Interview;

import java.util.*;

public class LSYInterview {
    public static void main(String[] args) {
        String str = "Hello world";


        Map<Character, Long> map = new LinkedHashMap<>();

        char[] words = str.toCharArray();

        for (char ch : words) {

            map.put(ch, map.getOrDefault(ch, 0L) + 1);
        }


        List<Character> topCharacters = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(e -> e.getKey()).limit(3).toList();
        System.out.println(topCharacters);
    }

    public static List<Character> getTopKFrequentCharacters(String str, int k) {

        Map<Character, Long> frequencyMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0L) + 1);
        }

        PriorityQueue<Map.Entry<Character, Long>> minHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Character, Long> entry : frequencyMap.entrySet()) {

            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Character> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);

        return result;
    }
}
