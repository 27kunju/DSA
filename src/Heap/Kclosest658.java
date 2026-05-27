package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kclosest658 {

    public List<Integer> getClosest(int[] nums, int k, int x) {

        int n = nums.length;

        int right = lowerBound(nums, x);
        int left = right - 1;

        List<Integer> result = new ArrayList<>();

        while (k > 0) {

            if (left < 0) {
                result.add(nums[right]);
                right++;
            }
            else if (right >= n) {
                result.add(nums[left]);
                left--;
            }
            else if (Math.abs(nums[left] - x)
                    <= Math.abs(nums[right] - x)) {

                result.add(nums[left]);
                left--;
            }
            else {
                result.add(nums[right]);
                right++;
            }

            k--;
        }

        Collections.sort(result);

        return result;
    }

    // first index >= x
    public int lowerBound(int[] nums, int x) {

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}