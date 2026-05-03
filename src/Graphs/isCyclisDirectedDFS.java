package Graphs;

import java.util.ArrayList;

public class isCyclisDirectedDFS {
    private boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj, int u,
                               boolean[] visited, boolean[] inRecursion) {

        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.get(u)) {

            // if not visited, then check cycle in DFS
            if (!visited[v] && isCycleDFS(adj, v, visited, inRecursion)) {
                return true;
            }
            // if already in recursion stack, cycle exists
            else if (inRecursion[v]) {
                return true;
            }
        }

        inRecursion[u] = false; // backtrack
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycleDFS(adj, i, visited, inRecursion)) {
                return true;
            }
        }

        return false;
    }

}
