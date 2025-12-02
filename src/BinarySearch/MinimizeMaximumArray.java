package BinarySearch;
import java.util.*;

public class MinimizeMaximumArray {
    private boolean isValid(int[] nums, int midMax) {
        int n = nums.length;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > midMax)
                return false;

            long buffer = midMax - arr[i];
            arr[i + 1] = arr[i + 1] - buffer;
        }

        return arr[n - 1] <= midMax;
    }

    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = Arrays.stream(nums).max().getAsInt();

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return result;
    }
}
