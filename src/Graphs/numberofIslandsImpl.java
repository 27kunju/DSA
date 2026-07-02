package Graphs;

public class numberofIslandsImpl {

    int rows;
    int cols;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0')
            return;

        // Mark as visited
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
