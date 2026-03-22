package Stack;

import java.util.Stack;

public class dailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove all elements that are not useful
            while (!stack.isEmpty() &&
                    temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // If stack is empty → no warmer day
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }

            // Push current index
            stack.push(i);
        }

        return result;
    }
}
