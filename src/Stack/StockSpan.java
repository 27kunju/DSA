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

    public int[] stockSpan(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0;i<n;i++){
            int span = 0;

            //why direction is backwards, we have to ith previous position first
            //i,i-1,i-2....0
            for (int j = i; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    span++;
                } else {
                    break;
                }
            }


            res[i] = span;
        }

        return res;


    }
}
