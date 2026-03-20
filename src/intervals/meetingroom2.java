package intervals;

import java.util.PriorityQueue;
import java.util.Arrays;


//Find the minimum number of meeting rooms required so that no meetings overlap.
public class meetingroom2 {
    public int minMeetingRooms(int[][] intervals) {

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min heap → stores end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            // If room is free, reuse it
            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }

            // Allocate room (push end time)
            minHeap.offer(end);
        }

        return minHeap.size();
    }

}
