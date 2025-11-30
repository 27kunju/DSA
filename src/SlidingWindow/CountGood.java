package SlidingWindow;
import java.util.*;

public class CountGood {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;

        Map<Integer, Integer> map = new HashMap<>();
        long pairs = 0;
        long res = 0;

        while (j < n) {
            // EXPAND
            int freq = map.getOrDefault(nums[j], 0);
            pairs += freq;                       // new pairs formed
            map.put(nums[j], freq + 1);

            // SHRINK until window has < k pairs
            while (pairs >= k) {
                res += (n - j);                  // all subarrays starting at i valid

                int leftFreq = map.get(nums[i]);
                pairs -= (leftFreq - 1);         // remove its contribution
                map.put(nums[i], leftFreq - 1);

                i++;
            }

            j++;
        }

        return res;
    }
}
