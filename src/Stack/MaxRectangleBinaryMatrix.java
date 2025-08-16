package Stack;

import java.util.*;

public class MaxRectangleBinaryMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1,1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0,0}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1: First row acts as initial histogram
        int[] heights = new int[m];
        for (int j = 0; j < m; j++) {
            heights[j] = matrix[0][j];
        }

        int maxArea = maximumAreaHistogram(heights);

        // Step 2: For each row, update heights and apply MAH
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    heights[j] = 0; // reset height
                } else {
                    heights[j] += matrix[i][j]; // increase height
                }
            }
            maxArea = Math.max(maxArea, maximumAreaHistogram(heights));
        }

        System.out.println("Maximum Rectangle Area in Binary Matrix = " + maxArea);
    }

    // Helper: Maximum Area Histogram
    static int maximumAreaHistogram(int[] arr) {
        int n = arr.length;
        int[] left = nearestSmallerToLeft(arr, n);
        int[] right = nearestSmallerToRight(arr, n);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    // Nearest Smaller to Left
    static int[] nearestSmallerToLeft(int[] arr, int n) {
        int[] left = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        return left;
    }

    // Nearest Smaller to Right
    static int[] nearestSmallerToRight(int[] arr, int n) {
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        return right;
    }
}
