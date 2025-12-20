package cumulative_sum;

import java.util.HashMap;
import java.util.Map;

public class minOperations1658 {

         public int minOperations(int[] nums, int x) {
         int n = nums.length;

         int totalSum = 0;
         for (int num : nums) totalSum += num;

         int target = totalSum - x;
         if (target < 0) return -1;

         if (target == 0) return n;

         Map<Integer, Integer> map = new HashMap<>();
         map.put(0, -1);

         int currSum = 0;
         int longest = Integer.MIN_VALUE;

         for (int i = 0; i < n; i++) {
             currSum += nums[i];


            //currSum - prevSum = target
             if (map.containsKey(currSum - target)) {
                 longest = Math.max(longest, i - map.get(currSum - target));
             }

             // store earliest index only
             if (!map.containsKey(currSum)) {
                 map.put(currSum, i);
             }
         }

         return longest == Integer.MIN_VALUE ? -1 : n - longest;
     }


     //optimized space to O(1), instead of using map . we are using sliding window to max Length
    public int minOperations2(int[] nums, int x) {
        int n = nums.length;
        int i = 0, j = 0;

        int totalSum = 0;
        for (int k = 0; k < n; k++) {
            totalSum += nums[k];
        }

        if (totalSum < x) return -1;

        int target = totalSum - x;
        int currSum = 0;

        int ans = -n;

        while (j < n) {
            currSum += nums[j];

            while (currSum > target) {
                currSum -= nums[i];
                i++;
            }

            if (currSum == target) {
                ans = Math.max(ans, j - i + 1);
            }

            j++;
        }

        if (ans == -n) return -1;
        return n - ans;
    }
}
