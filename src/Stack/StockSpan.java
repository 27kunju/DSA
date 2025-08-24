package Stack;

import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int n = arr.length;
        int[] span = new int[n];

        Stack<Integer> s = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop while stack is not empty and top element <= current price
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // If stack is empty → no greater element on left
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();

            }

            // Push current index
            s.push(i);
        }

        System.out.println("Stock Span: " + Arrays.toString(span));
    }
}
