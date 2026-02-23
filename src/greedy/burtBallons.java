package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class burtBallons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort balloons by start coordinate
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int arrows = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            // No overlap → need new arrow
            if (currStart > prevEnd) {
                arrows++;
                prevEnd = currEnd;
            } else {
                // Overlap → shrink intersection
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }

        return arrows;
    }
}
