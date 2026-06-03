package Graphs;

import java.util.*;

public class PrimsMST {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void prims(int V,
                             List<List<Pair>> graph) {

        boolean[] visited = new boolean[V];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(a -> a.weight));

        pq.offer(new Pair(0, 0));

        int mstWeight = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;

            if (visited[node])
                continue;

            visited[node] = true;

            mstWeight += curr.weight;

            for (Pair neighbor : graph.get(node)) {

                if (!visited[neighbor.node]) {

                    pq.offer(
                            new Pair(
                                    neighbor.node,
                                    neighbor.weight));
                }
            }
        }

        System.out.println("MST Weight = " + mstWeight);
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Pair>> graph =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 2));
        graph.get(1).add(new Pair(0, 2));

        graph.get(0).add(new Pair(3, 6));
        graph.get(3).add(new Pair(0, 6));

        graph.get(1).add(new Pair(2, 3));
        graph.get(2).add(new Pair(1, 3));

        graph.get(1).add(new Pair(3, 8));
        graph.get(3).add(new Pair(1, 8));

        graph.get(1).add(new Pair(4, 5));
        graph.get(4).add(new Pair(1, 5));

        graph.get(2).add(new Pair(4, 7));
        graph.get(4).add(new Pair(2, 7));

        prims(V, graph);
    }
}