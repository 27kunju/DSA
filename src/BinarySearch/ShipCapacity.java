package BinarySearch;

public class ShipCapacity {
    public boolean canComplete(int[] weights, int days, int capacity) {
        int dayCount = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                dayCount++;      // need new day
                currentLoad = 0; // reset load
            }
            currentLoad += w;
        }

        return dayCount <= days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w); // at least max weight
            high += w;              // at most sum of all weights
        }

        int res = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canComplete(weights, days, mid)) {
                res = mid;
                high = mid - 1;    // try smaller capacity
            } else {
                low = mid + 1;     // need bigger capacity
            }
        }

        return res;
    }
}
