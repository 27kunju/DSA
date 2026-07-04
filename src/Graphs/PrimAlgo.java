package Graphs;

import java.util.*;

public class PrimAlgo {
    static class Pair {
        int weight;
        int node;

        Pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        boolean[] inMST = new boolean[V];

        pq.offer(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int wt = current.weight;
            int node = current.node;

            if (inMST[node]) {
                continue;
            }

            inMST[node] = true;
            sum += wt;

            for (ArrayList<Integer> neighbor : adj.get(node)) {

                int adjacentNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                if (!inMST[adjacentNode]) {
                    pq.offer(new Pair(edgeWeight, adjacentNode));
                }
            }
        }

        return sum;
    }

}
