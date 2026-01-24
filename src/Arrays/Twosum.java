package Arrays;

import java.util.*;

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

    //when array is sorted - use 2 pointers

    public static int[] twoSum3(int[] nums, int target){
        int i = 0, j= nums.length-1;

        while(i<j){
            int sum = nums[i]+nums[j];

            if(sum <target){
                i++;
            }else if(sum >target){
                j--;
            }else if(sum == target){
                return new int[]{i,j};
            }
        }

        return new int[]{};
    }

    //when more than one solution is there
    public static List<int[]> twoSum4(int[] nums, int target){
        List<int[]> result = new ArrayList<>();

        int i = 0,j = nums.length-1;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                result.add(new int[]{i,j});


                while(i<j && nums[i] == nums[i]) i++;
                while(i<j && nums[j] == nums[j-1]) i--;

                i++;
                j--;

            }else if(sum <target){
                i++;
            }else if(sum>target){
                j--;
            }
        }

        return result;
    }
}
