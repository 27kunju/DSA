package Graphs;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;


/*Topological sorting using BFS */
public class KhansAlgo {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {

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
            indegree[v]++;   // v indegree increases
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with indegree 0
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);

            for(int neighbor : adj.get(curr)) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return res;
    }
}
