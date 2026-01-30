package BinarySearch;

import java.util.*;

public class minimumTimeTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (possible(time, mid, totalTrips)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;

        for (int t : time) {
            actualTrips += givenTime / t;
            if (actualTrips >= totalTrips) {
                return true;  // Early exit if we already have enough trips
            }
        }

        return actualTrips >= totalTrips;
    }
}
