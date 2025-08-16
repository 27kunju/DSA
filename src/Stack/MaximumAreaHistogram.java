package Stack;

import java.util.*;

public class MaximumAreaHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int n = arr.length;

        int[] left = nearestSmallerToLeft(arr, n);
        int[] right = nearestSmallerToRight(arr, n);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        System.out.println("Maximum Area Histogram = " + maxArea);
    }

    // Nearest Smaller to Left (returns indices)
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

    // Nearest Smaller to Right (returns indices)
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

