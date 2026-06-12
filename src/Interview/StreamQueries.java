package Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamQueries {

    // Sort characters in descending order
    public static String sortCharactersDescending(String str) {
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // Count character frequencies from a list of strings
    public static Map<Character, Long> countCharacters(List<String> words) {
        return words.stream()
                .flatMap(word -> word.chars().mapToObj(ch -> (char) ch))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                ));
    }

    // Top K frequent characters
    public static List<Character> topKFrequentCharacters(String str, int k) {

        Map<Character, Long> frequencyMap =
                str.chars()
                        .mapToObj(ch -> (char) ch)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        PriorityQueue<Map.Entry<Character, Long>> pq =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        frequencyMap.entrySet().forEach(entry -> {
            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        });

        List<Character> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {

        String str = "Hello world";

        // Query 1
        String sorted = sortCharactersDescending(str);
        System.out.println("Sorted Desc : " + sorted);

        // Query 2
        List<String> fruitsNames =
                Arrays.asList("apple", "orange", "banana");

        Map<Character, Long> charCount =
                countCharacters(fruitsNames);

        System.out.println("Character Count : " + charCount);

        // Query 3
        List<Character> top3 =
                topKFrequentCharacters(str, 3);

        System.out.println("Top 3 Characters : " + top3);
    }
}