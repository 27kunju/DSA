package Heap;

import java.util.PriorityQueue;
import java.util.Arrays;

public class kClosestPoints {
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            pq.offer(point);

            if (pq.size() > k) {
                pq.poll();   // remove farthest
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }


    public static void main(String[] args) {

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8}
        };

        int k = 2;

        int[][] result = kClosest(points, k);

        System.out.println("K Closest Points:");

        for (int[] p : result) {
            System.out.println(Arrays.toString(p));
        }

    }
}
