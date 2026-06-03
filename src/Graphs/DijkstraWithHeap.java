package Graphs;

import java.util.*;

public class DijkstraWithHeap {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int[][] cost, int src) {

        int V = cost.length - 1;

        int[] dist = new int[V + 1];

        boolean[] visited = new boolean[V + 1];

        dist[src] = 0;

        for (int i = 1; i <= V; i++) {
            dist[i] = cost[src][i];
        }

        visited[src] = true;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        // add initial distances
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                pq.offer(new Pair(i, dist[i]));
            }
        }

        for (int k = 1; k < V; k++) {

            int u = 0;

            // get minimum distance unvisited node
            while (!pq.isEmpty()) {

                Pair curr = pq.poll();

                if (!visited[curr.node]) {
                    u = curr.node;
                    break;
                }
            }

            if (u == 0) break;

            visited[u] = true;

            for (int v = 1; v <= V; v++) {

                if (!visited[v]
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + cost[u][v] < dist[v]) {

                    dist[v] = dist[u] + cost[u][v];

                    // push updated distance
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}