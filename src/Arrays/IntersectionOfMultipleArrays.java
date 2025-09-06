package Arrays;

import java.util.*;

public class IntersectionOfMultipleArrays {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,2,2},
                {1,1,2,2,2},
                {1,1,1,2,2,2}
        };

        List<Integer>  res = new ArrayList<>();
        res = intersection(arr);

        System.out.println(res);



    }
    public  static List<Integer> intersection(int[][] nums) {

        int[] freq = new int[1001];

        for(int[] num : nums){
            for(int ele : num){
                freq[ele]++;
            }
        }

        List<Integer> res = new ArrayList<>();

        int len = nums.length;

        for(int i =0 ; i<1001; i++){
            if(freq[i] == len){
                res.add(i);
            }
        }

        return res;


    }

    public static List<Integer> intersection2(int[][] nums) {
        Set<Integer> common = new HashSet<>();
        for (int num : nums[0]) {
            common.add(num);
        }

        // Process the remaining arrays
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> curr = new HashSet<>();
            for (int num : nums[i]) {
                curr.add(num);
            }
            common.retainAll(curr); // keep only common elements
        }

        // Convert to sorted list
        List<Integer> result = new ArrayList<>(common);
        Collections.sort(result);
        return result;
    }
}
