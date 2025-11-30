package SlidingWindow;

import java.util.*;

public class CountCompleteSubarrays {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        // Count distinct elements in whole array
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int c = set.size();

        int i = 0, j = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // shrink window until it's no longer complete
            while (map.size() == c) {
                res += (n - j); // all subarrays from i..j to i..(n-1)

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return res;
    }
}
