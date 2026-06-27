package intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class employeeFreeTime {

    public int[][] employeeFreeTime(int[][][] schedule) {

        List<int[]> intervals = new ArrayList<>();

        for (int[][] employee : schedule) {
            for (int[] interval : employee) {
                intervals.add(interval);
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = mergeIntervals(intervals);

        List<int[]> freeTime = new ArrayList<>();

        for (int i = 1; i < merged.size(); i++) {
            freeTime.add(new int[]{
                    merged.get(i - 1)[1],
                    merged.get(i)[0]
            });
        }

        return freeTime.toArray(new int[freeTime.size()][]);
    }

    private List<int[]> mergeIntervals(List<int[]> intervals) {

        List<int[]> merged = new ArrayList<>();

        for (int[] curr : intervals) {

            if (merged.isEmpty() ||
                    merged.get(merged.size() - 1)[1] < curr[0]) {

                merged.add(new int[]{curr[0], curr[1]});

            } else {

                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], curr[1]);
            }
        }

        return merged;
    }


    public int[][] employeeFreeTime2(int[][][] schedule) {

        List<int[]> intervals = new ArrayList<>();

        for (int[][] employee : schedule) {
            for (int[] interval : employee) {
                intervals.add(interval);
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int end = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);

            if (curr[0] > end) {
                result.add(new int[]{end, curr[0]});
            }

            end = Math.max(end, curr[1]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
