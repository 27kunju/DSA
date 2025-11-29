package Arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonrepeatingElement {
    public static int firstNonRepeating(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums)
          map.put(num, map.getOrDefault(num,0)+1);

        int index = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == 1)
                return indexOf(nums, num);
        }
        return -1;
    }

    private static int indexOf(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == key)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,4,2,5,5,6,1,6,3};
        System.out.println(firstNonRepeating(arr));
    }

}
