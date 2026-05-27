package HashMap;

public class makeSumDivisibleByP1590 {
    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;

        int totalSum = 0;

        for(int el : nums){
            totalSum += el;
        }

        int rem = totalSum %p;

        if(rem == 0) return 0;

        int i = 0, j = 0;

        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(j<n){
            sum += nums[j];
            while(sum>rem){
                sum -= nums[i];
                i++;
            }

            if(sum == rem){
                minLen = Math.min(minLen, j-i+1);
            }

            j++;

        }

        return minLen==Integer.MAX_VALUE? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,5,2};
        int p = 9;
        System.out.println(minSubarray(arr,p));
    }
}
