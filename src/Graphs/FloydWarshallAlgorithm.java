package Graphs;

public class FloydWarshallAlgorithm {
    public void shortestDistance(int[][] grid) {

        int n = grid.length;
        int INF = (int) 1e8;

        // Replace -1 with INF
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == -1) {
                    grid[i][j] = INF;
                }

                if (i == j) {
                    grid[i][j] = 0;
                }
            }
        }

        // Floyd-Warshall
        for (int via = 0; via < n; via++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (grid[i][via] != INF && grid[via][j] != INF) {

                        grid[i][j] = Math.min(
                                grid[i][j],
                                grid[i][via] + grid[via][j]
                        );
                    }
                }
            }
        }

        // Convert INF back to -1
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == INF) {
                    grid[i][j] = -1;
                }
            }
        }
    }
}
