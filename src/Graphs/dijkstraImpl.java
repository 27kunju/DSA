package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstraImpl {
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        // Min Heap
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int currDist = current.dist;

            // Skip outdated entries
            if (currDist > dist[node]) {
                continue;
            }

            for (Pair neighbour : adj.get(node)) {

                int adjNode = neighbour.node;
                int weight = neighbour.dist;

                if (currDist + weight < dist[adjNode]) {

                    dist[adjNode] = currDist + weight;

                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }
}
