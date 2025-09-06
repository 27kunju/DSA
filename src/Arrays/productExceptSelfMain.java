package Arrays;

public class productExceptSelfMain{
    //brute force
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0;i<nums.length ;i++){
            int product = 1;
            for(int j = 0; j<nums.length; j++){
                if( i != j){
                    product *=nums[j];
                }
            }
            res[i] = product;
        }

        return res;

    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: prefix products
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: multiply with suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }

}
