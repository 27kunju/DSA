package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//finding duplicates in sorted array
public class FindDuplicateElements {
    public static void main(String[] args) {
        int[] arr  = {3,6,8,8,8,10,10, 12,15,15,15,20};
        int lastDuplicate = 0;
        for(int i =0; i<arr.length-1 ; i++){
            if(arr[i] == arr[i+1] && arr[i] != lastDuplicate){
                System.out.println(arr[i]);
                lastDuplicate = arr[i];
            }
        }

    }

    // in unsorted array
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                res.add(entry.getKey());
            }
        }

        return res;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                res.add(i);
            }
        }

        return res;
    }
}
