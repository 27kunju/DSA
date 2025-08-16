package Stack;

import java.util.*;

public class NextGreatest {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Case 1: Stack empty
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

            // Push current element
            s.push(arr[i]);
        }

        System.out.println("Next Greater to Right: " + Arrays.toString(ans));
    }
}
