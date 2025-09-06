package Arrays;

import java.util.*;

public class ReArrangeArray {
    public static int[] reArrange(int[] arr) {
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length]; // mark used positives

        // Step 1: negatives and their matching positives
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                result.add(arr[i]);
                int pos = -arr[i];

                // Look for first unused positive match
                for (int j = 0; j < arr.length; j++) {
                    if (!used[j] && arr[j] == pos) {
                        result.add(arr[j]);
                        used[j] = true; // mark as used
                        break;
                    }
                }
            }
        }

        // Step 2: remaining positives
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && !used[i]) {
                result.add(arr[i]);
                used[i] = true;
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 11, 90, -2, 5, 7, 1, -1, 1, 2, -4};
        System.out.println(Arrays.toString(reArrange(arr)));
        // Output: [-2, 2, -1, 1, -4, 3, 9, 11, 90, 5, 7, 1]
    }
}
