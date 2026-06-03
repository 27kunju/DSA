package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{entrance[0], entrance[1]});

        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] curr = queue.poll();

                int i = curr[0];
                int j = curr[1];

                // Check if current cell is an exit
                if ((i != entrance[0] || j != entrance[1]) &&
                        (i == 0 || i == m - 1 ||
                                j == 0 || j == n - 1)) {
                    return steps;
                }

                // UP
                if (i - 1 >= 0 && maze[i - 1][j] == '.') {
                    maze[i - 1][j] = '+';
                    queue.offer(new int[]{i - 1, j});
                }

                // DOWN
                if (i + 1 < m && maze[i + 1][j] == '.') {
                    maze[i + 1][j] = '+';
                    queue.offer(new int[]{i + 1, j});
                }

                // LEFT
                if (j - 1 >= 0 && maze[i][j - 1] == '.') {
                    maze[i][j - 1] = '+';
                    queue.offer(new int[]{i, j - 1});
                }

                // RIGHT
                if (j + 1 < n && maze[i][j + 1] == '.') {
                    maze[i][j + 1] = '+';
                    queue.offer(new int[]{i, j + 1});
                }
            }

            steps++;
        }

        return -1;
    }
}
