package Graphs;

import java.util.*;

public class DijkstraWithoutHeap {

    public int[] dijkstra(int[][] cost, int src) {

        int V = cost.length - 1;

        int[] dist = new int[V + 1];

        boolean[] visited = new boolean[V + 1];

        dist[src] = 0;
        for (int i = 1; i <= V; i++) {
            dist[i] = cost[src][i];
        }



        visited[src] = true;

        for (int k = 1; k < V; k++) {

            int min = Integer.MAX_VALUE;

            int u = 0;

            for (int i = 1; i <= V; i++) {

                if (!visited[i] && dist[i] < min) {

                    min = dist[i];

                    u = i;
                }
            }

            visited[u] = true;

            for (int v = 1; v <= V; v++) {

                if (!visited[v]
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + cost[u][v] < dist[v]) {

                    dist[v] =
                            dist[u] + cost[u][v];
                }
            }
        }

        return dist;
    }
}