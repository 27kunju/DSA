package Graphs;

import java.util.*;


public class shortetPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        int[][] visited = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {

                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];

                if (i == n - 1 && j == n - 1) {
                    return level;
                }

                // up
                if (i > 0 && visited[i - 1][j] != 1 && grid[i - 1][j] == 0) {
                    visited[i - 1][j] = 1;
                    queue.offer(new int[]{i - 1, j});
                }

                // down
                if (i < n - 1 && visited[i + 1][j] != 1 && grid[i + 1][j] == 0) {
                    visited[i + 1][j] = 1;
                    queue.offer(new int[]{i + 1, j});
                }

                // left
                if (j > 0 && visited[i][j - 1] != 1 && grid[i][j - 1] == 0) {
                    visited[i][j - 1] = 1;
                    queue.offer(new int[]{i, j - 1});
                }

                // right
                if (j < n - 1 && visited[i][j + 1] != 1 && grid[i][j + 1] == 0) {
                    visited[i][j + 1] = 1;
                    queue.offer(new int[]{i, j + 1});
                }

                // top-right
                if (i > 0 && j < n - 1 &&
                        visited[i - 1][j + 1] != 1 &&
                        grid[i - 1][j + 1] == 0) {

                    visited[i - 1][j + 1] = 1;
                    queue.offer(new int[]{i - 1, j + 1});
                }

                // top-left
                if (i > 0 && j > 0 &&
                        visited[i - 1][j - 1] != 1 &&
                        grid[i - 1][j - 1] == 0) {

                    visited[i - 1][j - 1] = 1;
                    queue.offer(new int[]{i - 1, j - 1});
                }

                // bottom-left
                if (i < n - 1 && j > 0 &&
                        visited[i + 1][j - 1] != 1 &&
                        grid[i + 1][j - 1] == 0) {

                    visited[i + 1][j - 1] = 1;
                    queue.offer(new int[]{i + 1, j - 1});
                }

                // bottom-right
                if (i < n - 1 && j < n - 1 &&
                        visited[i + 1][j + 1] != 1 &&
                        grid[i + 1][j + 1] == 0) {

                    visited[i + 1][j + 1] = 1;
                    queue.offer(new int[]{i + 1, j + 1});
                }

                size--;
            }

            level++;
        }

        return -1;
    }
}
