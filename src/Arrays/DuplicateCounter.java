package Arrays;

import java.util.*;

public class DuplicateCounter {
    public static List<Integer> findDuplicatesWithCount(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Keep only duplicates
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 3, 1, 2};
        System.out.println(findDuplicatesWithCount(arr));
        // Example output: {2=3, 3=3}
    }
}
