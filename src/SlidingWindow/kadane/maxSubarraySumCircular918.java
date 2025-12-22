package SlidingWindow.kadane;

public class maxSubarraySumCircular918 {

  //brute force
    public int maxSubarraySumCircular1(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        // Try all rotations
        for (int start = 0; start < n; start++) {

            int[] rotated = new int[n];

            // Build rotated array
            for (int i = 0; i < n; i++) {
                rotated[i] = nums[(start + i) % n];
            }

            // Apply Kadane on rotated array
            ans = Math.max(ans, kadane(rotated));
        }

        return ans;
    }

    // Standard Kadane
    private int kadane(int[] arr) {
        int curr = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            max = Math.max(max, curr);
        }
        return max;
    }

    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int totalSum = 0;

        // Initialize for Kadane
        int maxEnding = nums[0], maxSoFar = nums[0];
        int minEnding = nums[0], minSoFar = nums[0];

        totalSum = nums[0];

        for (int i = 1; i < n; i++) {

            totalSum += nums[i];

            // Kadane for maximum subarray sum
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEnding);

            // Kadane for minimum subarray sum
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSoFar = Math.min(minSoFar, minEnding);
        }

        int circularSum = totalSum - minSoFar;

        // Edge case: all numbers are negative
        if (maxSoFar > 0) {
            return Math.max(maxSoFar, circularSum);
        }

        return maxSoFar;
    }
}
