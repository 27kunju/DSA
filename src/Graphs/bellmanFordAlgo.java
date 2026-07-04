package Graphs;

import java.util.*;

public class bellmanFordAlgo {
    public int[] bellmanFord(int V, int[][] edges, int S) {

        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e8);

        distance[S] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i <= V - 1; i++) {

            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (distance[u] != (int)1e8 &&
                        distance[u] + w < distance[v]) {

                    distance[v] = distance[u] + w;
                }
            }
        }

        // Detect negative weight cycle
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (distance[u] != (int)1e8 &&
                    distance[u] + w < distance[v]) {

                return new int[]{-1};
            }
        }

        return distance;
    }
}
