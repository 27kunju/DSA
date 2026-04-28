package Graphs;

import java.util.*;

public class bfsTraversal {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here

        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        visited[0] = true;

        while(!queue.isEmpty()){

            int node = queue.poll();
            res.add(node);

            for(int neighbour : adj.get(node)){

                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }


            }


        }

        return res;
    }


}
