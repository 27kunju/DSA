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

        //Java’s PriorityQueue is a min heap by default,
        // so it automatically keeps the smallest end time at the top without requiring explicit sorting

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

    public int minMeetingRooms2(int[][] intervals) {

        int n = intervals.length;

        int[] start = new int[n];
        int[] end = new int[n];

        // Separate start and end arrays
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int endPtr = 0;

        for (int i = 0; i < n; i++) {

            if (start[i] < end[endPtr]) {
                // Need new room
                rooms++;
            } else {
                // Reuse room
                endPtr++;
            }
        }

        return rooms;
    }

}
