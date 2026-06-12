package Interview.IDFCFirst;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {

    public static List<int[]> findCommonFreeTime(
            List<List<int[]>> calendars,
            int startOfDay,
            int endOfDay,
            int duration) {

        List<int[]> intervals = new ArrayList<>();

        // Collect all busy slots
        for (List<int[]> employee : calendars) {
            intervals.addAll(employee);
        }

        // Sort by start time
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        // Merge busy intervals
        List<int[]> merged = new ArrayList<>();

        for (int[] current : intervals) {

            if (merged.isEmpty() ||
                    merged.get(merged.size() - 1)[1] < current[0]) {

                merged.add(new int[]{
                        current[0],
                        current[1]
                });

            } else {

                merged.get(merged.size() - 1)[1] =
                        Math.max(
                                merged.get(merged.size() - 1)[1],
                                current[1]);
            }
        }

        // Find free slots
        List<int[]> result = new ArrayList<>();

        int previousEnd = startOfDay;

        for (int[] busy : merged) {

            if (busy[0] - previousEnd >= duration) {

                result.add(new int[]{
                        previousEnd,
                        busy[0]
                });
            }

            previousEnd =
                    Math.max(previousEnd, busy[1]);
        }

        // After last meeting
        if (endOfDay - previousEnd >= duration) {

            result.add(new int[]{
                    previousEnd,
                    endOfDay
            });
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<int[]>> calendars = List.of(

                List.of(
                        new int[]{9,10},
                        new int[]{12,13},
                        new int[]{16,18}
                ),

                List.of(
                        new int[]{10,11},
                        new int[]{12,14},
                        new int[]{16,17}
                ),

                List.of(
                        new int[]{9,10},
                        new int[]{13,14},
                        new int[]{15,16}
                )
        );

        List<int[]> result =
                findCommonFreeTime(
                        calendars,
                        9,
                        18,
                        1);

        for (int[] slot : result) {
            System.out.println(
                    "[" + slot[0] + ", " + slot[1] + "]"
            );
        }
    }
}