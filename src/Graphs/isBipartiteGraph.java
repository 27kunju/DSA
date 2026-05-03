package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class isBipartiteGraph {
    public boolean dfs(int[][] graph, int node, int[] color, int currColor) {
        color[node] = currColor;

        for (int neighbor : graph[node]) {

            // If neighbor has same color => not bipartite
            if (color[neighbor] == currColor) {
                return false;
            }

            // If neighbor not colored, color it and recurse
            if (color[neighbor] == -1) {
                if (!dfs(graph, neighbor, color, 1 - currColor)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int[][] graph, int node, int[] color, int currColor) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = currColor;

        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int v : graph[u]){
                if(color[v] == color[u]){
                    return false;
                }else if(color[v] == -1){
                    color[v] = 1- color[u];
                    queue.offer(v);
                }
            }

        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        // fill with -1
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) { // not visited
                if (!dfs(graph, i, color, 0)) {
                    return false;
                }
            }
        }

        return true;
    }
}
