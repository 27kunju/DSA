package BinarySearch;

public class maxBoundedArray {
    private long getSumElements(long count, long val) {
        // sum of decreasing sequence: val + (val-1) + ... for 'count' terms
        return val * count - (count * (count + 1)) / 2;
    }

    public int maxValue(int n, int index, int maxSum) {

        long left = 1;
        long right = maxSum;
        int result = 0;

        while (left <= right) {
            long midVal = left + (right - left) / 2;

            // -------- LEFT SIDE --------
            long leftCount = Math.min(index, midVal - 1);
            long leftSum = getSumElements(leftCount, midVal);

            // If left side needs padding with 1s
            leftSum += Math.max(0L, index - (midVal - 1));

            // -------- RIGHT SIDE --------
            long rightCount = Math.min(n - index - 1, midVal - 1);
            long rightSum = getSumElements(rightCount, midVal);

            // If right side needs padding with 1s
            rightSum += Math.max(0L, n - index - 1 - (midVal - 1));

            long total = leftSum + rightSum + midVal;

            // Check if valid under maxSum
            if (total <= maxSum) {
                result = (int) Math.max(result, midVal);
                left = midVal + 1; // try larger peak
            } else {
                right = midVal - 1; // reduce peak
            }
        }

        return result;
    }
}
