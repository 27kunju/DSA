package Arrays;

import java.util.ArrayList;
import java.util.List;

public class findDissappearedNumsMain {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // Step 1: Mark visited numbers
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;  // map number to index
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];       // mark as visited
            }
        }

        // Step 2: Collect missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {  // not visited
                res.add(i + 1);
            }
        }

        return res;
    }

    //bruteforce
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        List<Integer> res = new ArrayList<>();

        for(int ele : nums){
            freq[ele]++;
        }

        for(int i =1; i<=n;i++){
            if(freq[i] ==0){
                res.add(i);
            }
        }

        return res;


    }
}
