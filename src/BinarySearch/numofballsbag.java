package BinarySearch;

import java.util.*;
public class numofballsbag {
    private boolean canReduce(int[] nums, int maxOps, int mid) {
        long totalOps = 0;

        for (int num : nums) {
            // number of splits needed
            totalOps += (num - 1) / mid;
            if (totalOps > maxOps) return false; // early stop
        }

        return totalOps <= maxOps;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canReduce(nums, maxOperations, mid)) {
                ans = mid;
                right = mid - 1; // try smaller
            } else {
                left = mid + 1; // need bigger
            }
        }

        return ans;
    }
}
