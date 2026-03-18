package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySum {

    //LC -3381

    public long maxSubArraySum(int[] nums, int k){
        int n = nums.length;
        long res = Long.MIN_VALUE;


        for(int i = 0; i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += nums[j];


                if((j-i+1)%k == 0) {
                    res = Math.max(res, sum);
                }
            }
        }

        return res;
    }
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] prefSum = new long[n];
        prefSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
        }

        long result = Long.MIN_VALUE;

        for (int start = 0; start < k; start++) {
            long currSum = 0;

            int i = start;
            while (i < n && i + k - 1 < n) {
                int j = i + k - 1;

                long subSum = prefSum[j] - (i > 0 ? prefSum[i - 1] : 0);

                currSum = Math.max(subSum, currSum + subSum);

                result = Math.max(result, currSum);

                i += k;
            }
        }

        return result;
    }

    public static long maxSubarraySum2(int[] nums, int k) {

        long sum = 0;
        long res = Long.MIN_VALUE;

        // remainder -> minimum prefix sum
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = (i + 1) % k;

            if (map.containsKey(rem)) {
                res = Math.max(res, sum - map.get(rem));
            }

            map.put(rem, Math.min(map.getOrDefault(rem, Long.MAX_VALUE), sum));
        }

        return res;
    }
}
