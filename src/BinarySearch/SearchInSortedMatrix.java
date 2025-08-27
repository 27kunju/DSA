package BinarySearch;

import java.util.Arrays;

public class SearchInSortedMatrix {

    public static int[] searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0, j = cols - 1; // start at top-right corner

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return new int[]{i,j}; // found
            } else if (matrix[i][j] > target) {
                j--; // move left
            } else {
                i++; // move down
            }
        }
        return new int[]{-1,-1}; // not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target1 = 5;
        int target2 = 20;

        System.out.println("Is " + target1 + " present? " + Arrays.toString(searchMatrix(matrix, target1)));
        System.out.println("Is " + target2 + " present? " + Arrays.toString(searchMatrix(matrix, target2)));
    }
}
