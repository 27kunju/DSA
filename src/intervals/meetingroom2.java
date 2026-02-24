package intervals;

import java.util.TreeMap;

public class meetingroom2 {
    public int minMeetingRooms(int[] start, int[] end) {
        int n = start.length;

        // Ordered map: time -> change in active meetings
        TreeMap<Integer, Integer> events = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            events.put(start[i], events.getOrDefault(start[i], 0) + 1);
            events.put(end[i],   events.getOrDefault(end[i],   0) - 1);
        }

        int overlaps = 0;
        int maxOverlaps = 0;

        for (int delta : events.values()) {
            overlaps += delta;
            maxOverlaps    = Math.max(maxOverlaps, overlaps);
        }

        return maxOverlaps;
    }
}
