package Graphs;

import java.util.*;

public class isCyclicBfs {
    public boolean isCycle(int V, int[][] edges) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adj, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, -1}); // {node, parent}
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int parent = cur[1];

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new int[]{neighbor, node});
                }
                else if (neighbor != parent) {
                    return true; // cycle detected
                }
            }
        }

        return false;
    }
}
