package HashMap;

import java.util.HashMap;
import java.util.Map;

public class subarraysDivByK974 {
    public int subarraysDivByK(int[] nums, int k) {

         int n = nums.length;
         int count = 0;

         for(int i = 0;i<n;i++){
             int sum = 0;
             for(int j = i;j<n;j++){
                 sum += nums[j];
                 if(sum %k == 0){
                     count++;
                 }
             }
         }

         return count;
    }

    public int subarraysDivByK2(int[] nums, int k) {
        int n = nums.length;

        int result = 0;          // total count of valid subarrays
        int sum = 0;             // running prefix sum

        // remainder -> frequency map
        // stores how many times a particular remainder has appeared
        Map<Integer, Integer> map = new HashMap<>();

        // Base case:
        // prefixSum = 0 has remainder 0 once
        // helps count subarrays starting from index 0
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];      // update prefix sum

            int rem = sum % k;   // compute remainder

            // Normalize negative remainder
            // Java can return negative % values
            // e.g., -4 % 7 = -4 → normalize to 3
            if (rem < 0) {
                rem += k;
            }

            // If this remainder was seen before,
            // each previous occurrence forms a valid subarray
            // ending at index i
            if (map.containsKey(rem)) {
                result += map.get(rem);
            }

            // Store/update the frequency of this remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return result;
    }

}
