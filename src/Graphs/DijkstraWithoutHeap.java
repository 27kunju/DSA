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


    public int[] dijkstra(int V,
                          int[][] edges,
                          int src) {

        // create adjacency matrix
        int[][] cost = new int[V][V];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            cost[u][v] = w;
            cost[v][u] = w;
        }

        int[] dist = new int[V];

        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Dijkstra
        for (int k = 0; k < V - 1; k++) {

            int min = Integer.MAX_VALUE;

            int u = -1;

            // find minimum unvisited node
            for (int i = 0; i < V; i++) {

                if (!visited[i]
                        && dist[i] < min) {

                    min = dist[i];
                    u = i;
                }
            }

            if (u == -1) {
                break;
            }

            visited[u] = true;

            // relax neighbors
            for (int v = 0; v < V; v++) {

                if (!visited[v]
                        && cost[u][v] != 0
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