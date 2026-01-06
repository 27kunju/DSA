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


    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int i = 0,j=0;
        int count =0;

        int window_sum = 0;
        int zero_count =0;
        while(j<n){
            window_sum +=nums[j];

            while(i<j &&(nums[i] == 0 || window_sum >goal)){
                if(nums[i] == 0){
                    zero_count++;
                }else{
                    zero_count = 0;
                }

                window_sum -=nums[i];
                i++;
            }

            if(window_sum == goal){
                count += 1+zero_count;
            }

            j++;
        }

        return count;

    }
}
