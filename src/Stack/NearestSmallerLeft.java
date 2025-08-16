package Stack;

import java.util.*;

public class NearestSmallerLeft {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Case 1: stack empty
            if (s.isEmpty()) {
                ans[i] = -1;
            }
            // Case 2: top < current
            else if (!s.isEmpty() && s.peek() < arr[i]) {
                ans[i] = s.peek();
            }
            // Case 3: keep popping until smaller found
            else if (!s.isEmpty() && s.peek() >= arr[i]) {
                while (!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }
                ans[i] = s.isEmpty() ? -1 : s.peek();
            }

            // Push current
            s.push(arr[i]);
        }

        System.out.println("Nearest Smaller to Left: " + Arrays.toString(ans));
    }
}
