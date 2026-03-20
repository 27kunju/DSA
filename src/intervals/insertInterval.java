package intervals;

import java.util.ArrayList;
import java.util.List;

public class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] result = new int[intervals.length + 1][2];
        int i = 0, j = 0;

        // 1️⃣ Add all intervals that come before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }

        // 2️⃣ Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // 3️⃣ Add merged newInterval
        result[j++] = newInterval;

        // 4️⃣ Add remaining intervals
        while (i < intervals.length) {
            result[j++] = intervals[i++];
        }

        return java.util.Arrays.copyOf(result, j);
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] curr : intervals) {

            // Case 1: No overlap, current interval is completely before newInterval
            if (curr[1] < newInterval[0]) {
                result.add(curr);
            }
            // Case 2: No overlap, current interval is completely after newInterval
            else if (curr[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = curr; // update newInterval for next comparisons
            }
            // Case 3: Overlap (FULL CONDITION)
            else if (curr[0] <= newInterval[1] && newInterval[0] <= curr[1]) {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }

        // Add the last interval
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }

    /*
    In Our Code Context

intervals[i] = [start, end]

newInterval = [newStart, newEnd]

So overlap becomes:

intervals[i][0] <= newInterval[1]
AND
newInterval[0] <= intervals[i][1]
     */
}
