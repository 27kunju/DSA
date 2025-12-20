package HashMap;

import java.util.HashMap;
import java.util.Map;

public class numSubarraysWithSum {

    //LC -930
    public int numSubarraysWithSum1(int[] nums, int goal) {
         int n = nums.length;

         int result = 0;
         for(int i = 0;i<n;i++){
             int sum =0;
             for(int j = i;j<n;j++){
                 sum +=nums[j];
                 if(sum == goal){
                     result++;
                 }
             }
         }

         return result;
     }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // base case

        int curSum = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            curSum += nums[i];

            int diff = curSum - goal;
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return result;

    }
}
