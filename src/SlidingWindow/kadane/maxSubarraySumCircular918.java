package SlidingWindow.kadane;

public class maxSubarraySumCircular918 {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int maxSum = Integer.MIN_VALUE, currMax = 0;
        int minSum = Integer.MAX_VALUE, currMin = 0;

        for (int n : nums) {
            total += n;

            // Kadane for max
            currMax = Math.max(currMax + n, n);
            maxSum = Math.max(maxSum, currMax);

            // Kadane for min
            currMin = Math.min(currMin + n, n);
            minSum = Math.min(minSum, currMin);
        }

        // If all numbers are negative, circularMax = 0 (invalid), return maxSum
        if (total == minSum) {
            return maxSum;
        }

        // Otherwise, max between normal Kadane + circular Kadane
        return Math.max(maxSum, total - minSum);
    }
}
