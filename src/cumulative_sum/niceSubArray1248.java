package cumulative_sum;

import java.util.HashMap;

public class niceSubArray1248{
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int currSum = 0;
        map.put(currSum, 1);

        for (int i = 0; i < n; i++) {
            currSum += (nums[i] % 2); // if odd - 1, even - 0

            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
    public int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length;

        int oddCount = 0;
        int count = 0;
        int result = 0;

        int i = 0;
        int j = 0;

        // Best example to understand the use of count variable - {2, 1, 2, 1}, output : 6
        while (j < n) {
            if (nums[j] % 2 != 0) { // ODD
                oddCount++;
                count = 0;
            }

            while (oddCount == k) {
                count++;

                if (i < j && nums[i] % 2 == 1) { // ODD
                    oddCount--;
                }
                i++;
            }

            result += count;
            j++;
        }

        return result;
    }
}
