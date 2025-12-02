package BinarySearch;

public class NumOfBouquets {
    private boolean canMake(int[] bloomDay, int day, int k, int target) {
        int consecutive = 0;
        int bouquets = 0;

        for (int bd : bloomDay) {
            if (bd <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    if (bouquets == target) return true; // early success
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int bd : bloomDay) {
            low = Math.min(low, bd);
            high = Math.max(high, bd);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, k, m)) {
                ans = mid;        // mid is feasible
                high = mid - 1;   // try earlier day
            } else {
                low = mid + 1;    // need more days
            }
        }

        return ans;
    }
}
