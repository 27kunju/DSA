package intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.Arrays;

public class mergeInterval {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));

        List<int[]> result = new ArrayList<>();

        int[] previousInterval = intervals[0];
        result.add(previousInterval);
        for(int[] interval :intervals){
            if(interval[0] <= previousInterval[1])
                previousInterval[1] = Math.max(previousInterval[1], interval[1]);
            else{
                previousInterval = interval;
                result.add(previousInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
