package Graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class topology {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // run dfs for all nodes (disconnected graph also)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        int[] topo = new int[V];
        int index = 0;

        while (!stack.isEmpty()) {
            topo[index++] = stack.pop();
        }

        return topo;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // push after visiting all neighbors
        stack.push(node);
    }
}
