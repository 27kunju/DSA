package intervals;
import java.util.Arrays;
import java.util.PriorityQueue;


public class minimumPlatform {
    public static void main(String[] args) {
        int[] arr = {1000, 935, 1100};
        int[] dep = {1200, 1240, 1130};

        int maxPlatform = getPlatformCount(arr,dep);
        System.out.println(maxPlatform);



    }
    public static int getPlatformCount(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int platforms = 0, maxPlatforms = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {

                //When a train departs, it frees a platform, so we decrement the platform count.
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }

    int minPlatforms2(int[] arr, int[] dep) {
        int n = arr.length;

        // Step 1: Pair arrival & departure and sort by arrival time
        int[][] trains = new int[n][2];
        for (int i = 0; i < n; i++) {
            trains[i][0] = arr[i];
            trains[i][1] = dep[i];
        }

        Arrays.sort(trains, (a, b) -> a[0] - b[0]);

        // Step 2: Min-heap to track earliest departure
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int maxPlatforms = 0;

        for (int[] train : trains) {
            int arrival = train[0];
            int departure = train[1];

            // Remove trains that have already departed
            while (!pq.isEmpty() && pq.peek() < arrival) {
                pq.poll();
            }

            // Add current train
            pq.offer(departure);

            maxPlatforms = Math.max(maxPlatforms, pq.size());
        }

        return maxPlatforms;
    }
}
