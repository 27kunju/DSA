package BinarySearch;

public class NumOfBouquets {
    public boolean canMake(int[] bloomDay, int day, int k, int m) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
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
