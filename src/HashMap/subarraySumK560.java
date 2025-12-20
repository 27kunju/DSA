package HashMap;

import java.util.HashMap;
import java.util.Map;

public class subarraySumK560 {

    //brute force
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int result = 0;

        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;i++){
                sum +=nums[j];
                if(sum==k){
                    result++;
                }
            }
        }

        return result;
    }

    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0;

        for(int i = 0;i<n;i++){
            sum += nums[i];

            int diff = sum -k;
            if(map.containsKey(diff)){
                result += map.get(diff);
            }

            map.put(diff, map.getOrDefault(sum,0)+1);

        }

        return result;

    }
}
