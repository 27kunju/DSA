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
}
