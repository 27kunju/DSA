package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class rottenOrangeImpl {

    public int rottenOrange(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        if(freshCount == 0) return 0;

        int minTime = 0;


        while(!queue.isEmpty()){
            int n = queue.size();

            while(n>0){
                int[] currentRotten = queue.poll();
                int i = currentRotten[0];
                int j = currentRotten[1];

                if(i+1<rows && grid[i+1][j] == 1){

                    grid[i+1][j] = 2;
                    freshCount--;
                    queue.offer(new int[]{i+1,j});
                }

                if(i-1>=0 && grid[i-1][j] ==1){
                    grid[i-1][j] = 2;
                    freshCount--;
                    queue.offer(new int[]{i-1,j});
                }

                if(j+1<cols && grid[i][i+1] == 1){
                    grid[i][j+1] =2;
                    freshCount--;
                    queue.offer(new int[]{i,j-1});

                }

                if(j-1>=0 && grid[i][j-1]==1){
                    grid[i][j-1]=2;
                    freshCount--;
                    queue.offer(new int[]{i,j-1});
                }
                n--;
            }

            minTime++;
        }

        return freshCount == 0 ? minTime : -1;
    }
}
