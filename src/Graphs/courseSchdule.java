package Graphs;

import java.util.*;

public class courseSchdule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i = 0;i<numCourses;i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] nodes : prerequisites){
            int u = nodes[0];
            int v  = nodes[1];

            adj.get(v).add(u);
            indegree[u]++;

        }

        return topologicalSort(adj, numCourses, indegree);


    }

    public boolean topologicalSort(Map<Integer,List<Integer>> adj, int n , int[] indegree){

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;

        // Add all nodes with indegree 0
        for(int i = 0; i < n ; i++) {
            if(indegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }


        while(!queue.isEmpty()) {
            int curr = queue.poll();


            for(int neighbor : adj.get(curr)) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    count++;

                    queue.offer(neighbor);
                }
            }
        }


        return count == n;


    }
}
