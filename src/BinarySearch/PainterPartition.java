package BinarySearch;

import java.util.*;

public class PainterPartition {

    public static void main(String[] args) {

        int[] canvas = {5, 10, 30, 20, 15};
        int painters = 3;

        int minTime = getMinTime(canvas, painters);
        System.out.println("Minimum time required: " + minTime);
    }

    // Binary Search on Answer
    public static int getMinTime(int[] canvas, int painters) {

        int l = 0, h = 0;

        // Define search space
        for (int i : canvas) {
            l = Math.max(l, i);   // largest single board
            h += i;               // total painting time
        }

        int ans = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (canComplete(canvas, mid, painters)) {
                ans = mid;        // valid answer
                h = mid - 1;      // try smaller maximum
            } else {
                l = mid + 1;      // increase time
            }
        }
        return ans;
    }

    // Greedy feasibility check
    public static boolean canComplete(int[] canvas, int maxTime, int painters) {

        int painterCount = 1;
        int timeSum = 0;

        for (int i = 0; i < canvas.length; i++) {

            if (timeSum + canvas[i] > maxTime) {
                painterCount++;
                timeSum = canvas[i];

                if (painterCount > painters) return false;
            } else {
                timeSum += canvas[i];
            }
        }
        return painterCount <= painters;
    }

}
