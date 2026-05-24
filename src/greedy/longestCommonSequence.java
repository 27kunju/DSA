package greedy;

import java.util.Arrays;

public class longestCommonSequence {
    public int getLongestCommonSequence(int[] nums){

        int n = nums.length;
        Arrays.sort(nums);

        int currentLen  = 1;

        int longest = 1;

        for(int i = 1;i<n;i++){

            if(nums[i] == nums[i-1]){
                continue;
            }

            if(nums[i] == nums[i-1]+1){
                currentLen++;
            }else{
                longest = Math.max(currentLen, longest);
                currentLen = 1;
            }
        }

        //Loop handles breaks, final check handles last streak
        longest = Math.max(currentLen, longest);

        return longest;
    }
}
