package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twosum {
    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        int[] pairs = twoSum2(nums, target);
        System.out.println(Arrays.toString(pairs));
    }

    public static int[] twoSum(int[] nums, int target){
        int n = nums.length;

        for(int i =0; i<n ; i++){
            for(int j = i+1; j<n ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1,-1};
    }

    public static  int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};

    }
}
