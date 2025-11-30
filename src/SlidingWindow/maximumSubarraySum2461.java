package SlidingWindow;
import java.util.*;
public class maximumSubarraySum2461 {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        int i = 0, j = 0;

        long sum = 0, max = 0;
        Set<Integer> set = new HashSet<>();

        while (j < n) {

            // 1. Expand window by adding nums[j]
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            // 2. If window > k → shrink
            while (j - i + 1 > k) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            // 3. Valid window of size k
            if (j - i + 1 == k) {
                max = Math.max(max, sum);
            }

            j++; // move right
        }

        return max;
    }
}
