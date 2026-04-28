package Graphs;

import java.util.*;

public class dfsTraversal {

    public List<Integer> dfs(List<List<Integer>> adj){

        Map<Integer, List<Integer>> map = new HashMap<>();

        int V = adj.size();

        for(int i = 0;i<V;i++){

            map.put(i, new ArrayList<>());

            for(int neighbours : adj.get(i)){
                map.get(i).add(neighbours);
            }
        }

        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfsHelper(0, map, visited, res);

        return res;


    }

    private void dfsHelper(int node, Map<Integer,List<Integer>> map, boolean[] visited, List<Integer> res){
        visited[node] = true;
        res.add(node);

        for(int neibours: map.get(node)){

            if(!visited[neibours]){
                dfsHelper(neibours, map, visited,res);
            }
        }

    }


}
