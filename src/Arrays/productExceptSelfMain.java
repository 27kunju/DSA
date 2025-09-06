package Arrays;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> findDuplicatesContantSpace(int[] nums){
        List<Integer> resultSet = new ArrayList<>();

        for(int i =0; i<nums.length ;i++){
            //get the index ,the element corresponds to
            int index = Math.abs(nums[i])-1;

            //if the number is already negative, it mean we are
            //encountering it twice
            if(nums[index] <0){
                resultSet.add(index+1);
            }

            //flip the number at the index to negative
            nums[index] = nums[index]* -1;

        }

        return resultSet;
    }

}
