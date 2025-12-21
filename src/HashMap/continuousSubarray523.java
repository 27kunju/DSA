package HashMap;

import java.util.HashMap;
import java.util.Map;

public class continuousSubarray523 {

    //brute force
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum % k == 0 && (j - i + 1 >= 2)) {
                    return true;
                }

            }
        }

        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;

        // remainder -> earliest index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // important for subarrays starting at index 0

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int rem = (k == 0) ? sum : sum % k;

            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                // store only the first occurrence
                map.put(rem, i);
            }
        }

        return false;
    }
}
