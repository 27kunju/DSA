package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class isCyclicDirectedBFS {
    public boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Build graph + indegree
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Push all indegree 0 nodes
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0; // number of processed nodes

        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // if not all nodes processed => cycle exists
        return count != V;
    }
}
