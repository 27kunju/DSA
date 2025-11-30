package SlidingWindow.kadane;

public class maxSumArraySizeDivisibleByK {


    //brute force
    public static long maxSubarraySum(int[] nums, int k) {

        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0;i<n;i++){
            for(int j = i;j<n;j++){
                sum +=nums[j];

                if(j-i+1 %k == 0){
                    max = Math.max(max,j-i+1);
                }
            }
        }

        return max;


    }
}
