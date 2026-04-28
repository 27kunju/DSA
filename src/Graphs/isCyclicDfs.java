package Graphs;

import java.util.*;

public class isCyclicDfs {
    public boolean isCycle(int V, int[][] edges) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);  // undirected
        }

        boolean[] visited = new boolean[V];

        // check all components,includes disconnected graphs,
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(adj, i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] visited) {

        visited[node] = true;

        for(int neighbor : adj.get(node)) {

            if(neighbor == parent) continue;

            if(visited[neighbor]) return true;

            if(dfs(adj, neighbor, node, visited)) return true;
        }

        return false;
    }
}
