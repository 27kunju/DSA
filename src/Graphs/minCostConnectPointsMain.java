package Graphs;

import java.util.*;

public class minCostConnectPointsMain {
    static class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        boolean[] visited = new boolean[n];

        pq.offer(new Pair(0, 0));

        int totalCost = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < n) {

            Pair current = pq.poll();

            int node = current.node;
            int cost = current.cost;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalCost += cost;
            edgesUsed++;

            for (int next = 0; next < n; next++) {

                if (!visited[next]) {

                    int distance =
                            Math.abs(points[node][0] - points[next][0]) +
                                    Math.abs(points[node][1] - points[next][1]);

                    pq.offer(new Pair(next, distance));
                }
            }
        }

        return totalCost;
    }
}
