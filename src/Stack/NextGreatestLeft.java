package Stack;

import java.util.*;

public class NextGreatestLeft {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Case 1: Stack empty → no greater element on left
            if (s.isEmpty()) {
                ans[i] = -1;
            }
            // Case 2: Top element > current element
            else if (!s.isEmpty() && s.peek() > arr[i]) {
                ans[i] = s.peek();
            }
            // Case 3: Pop until greater element found
            else if (!s.isEmpty() && s.peek() <= arr[i]) {
                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }
                ans[i] = s.isEmpty() ? -1 : s.peek();
            }

            // Push current element for future comparisons
            s.push(arr[i]);
        }

        System.out.println("Final Stack (bottom to top): " + s);

        System.out.println("Next Greater to Left: " + Arrays.toString(ans));
    }
}
