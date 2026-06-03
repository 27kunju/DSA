package Interview.IDFCFirst;
/*
startup owner wants have meetings with Investers
given firstday,lastday availability of each inverstores,
owner can meet only one investor in a day
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class meetupSchdule {
    public static int countNumberofMeetings(int[] firstDay, int[] lastDay) {
        int n = firstDay.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = firstDay[i];
            meetings[i][1] = lastDay[i];
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        int day = 0;
        int j = 0;
        int count =0;

        while (!pq.isEmpty() || j < n) {

            if (pq.isEmpty()) {
                day = meetings[j][0];
            }

            while (j < n && meetings[j][0] == day) {
                pq.offer(meetings[j][1]);
                j++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }

            day++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] firstDay = {5,15};
        int[] lastDay = {10,20};

        System.out.println(countNumberofMeetings(firstDay,lastDay));
    }

}
