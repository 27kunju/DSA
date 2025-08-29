package Arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfArraysMain {
    public static void main(String[] args) {
        int[][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        List<Integer> commonElements = interSectionArrays(nums);

        commonElements.forEach(System.out::println);
    }
    public static List<Integer> interSectionArrays(int[][] nums){

        int[] freq = new int[1001];

        for(int[] num : nums){
            for(int ele : num){
                freq[ele]++;
            }
        }

        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        for(int i = 0; i<1001;i++){
            if(freq[i] == len){
                res.add(i);
            }
        }

        return res;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] freq = new int[1001]; // since nums[i] <= 1000
        List<Integer> list = new ArrayList<>();

        // count frequency of nums1
        for (int num : nums1) {
            freq[num]++;
        }

        // check nums2 against freq
        for (int num : nums2) {
            if (freq[num] > 0) {
                list.add(num);
                freq[num]--; // reduce count since it is used
            }
        }

        // convert list to array
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

    }
}
