package SlidingWindow;

public class CountSubarrays {

    //lc -2962
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        // Find max element
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int i = 0, j = 0;
        long countMax = 0;   // how many times max appears in window
        long result = 0;

        while (j < n) {

            // 1. EXPAND window
            if (nums[j] == max) countMax++;

            // 2. SHRINK while max appears >= k times
            while (countMax >= k) {
                result += (n - j);   // all windows from i..j, i+1..j, ... valid

                if (nums[i] == max) countMax--;
                i++;
            }

            j++;
        }

        return result;
    }
}
