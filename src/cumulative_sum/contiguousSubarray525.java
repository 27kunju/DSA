package cumulative_sum;

import java.util.HashMap;

public class contiguousSubarray525 {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0, ones = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == 0) zeros++;
                else ones++;

                if (zeros == ones) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

// Array contains only 0s and 1s
// Goal: find the maximum length subarray with equal number of 0s and 1s
// Trick:
//   Replace 0 -> -1
//   Keep 1 as +1
// Now the problem becomes:
//   Find the longest subarray with sum = 0

    public int findMaxLength2(int[] nums) {
        int n = nums.length;

        // If only one element, we can never have equal 0s and 1s
        if (n == 1) return 0;

        // HashMap to store:
        // key   -> prefix sum
        // value -> first index where this prefix sum occurred
        HashMap<Integer, Integer> mp = new HashMap<>();

        int currSum = 0;   // running prefix sum
        int maxL = 0;      // maximum length of valid subarray

        // Base case:
        // prefix sum = 0 at index -1
        // This helps handle subarrays starting from index 0
        mp.put(0, -1);

        for (int i = 0; i < n; i++) {

            // Convert the problem:
            // 1  -> +1
            // 0  -> -1
            currSum += (nums[i] == 1) ? 1 : -1;

            // If current prefix sum has been seen before,
            // then the subarray between previous index + 1 and current index
            // has sum = 0 (equal number of 0s and 1s)
            if (mp.containsKey(currSum)) {

                // Length of subarray = current index - first occurrence index
                maxL = Math.max(maxL, i - mp.get(currSum));

            } else {
                // IMPORTANT:
                // Store only the FIRST occurrence of a prefix sum
                // because earlier index gives a longer subarray
                // Do NOT overwrite existing index
                mp.put(currSum, i);
            }
        }

        return maxL;
    }

}
