package Stack;

import java.util.Stack;

public class MinStackOptimized {
    private Stack<Integer> stack;
    private int minElement;

    public MinStackOptimized() {
        stack = new Stack<>();
    }

    // Push element
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minElement = x;
        } else {
            if (x >= minElement) {
                stack.push(x);
            } else {
                // Encode value
                stack.push(2 * x - minElement);
                minElement = x;
            }
        }
    }

    // Pop element
    public void pop() {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        if (top < minElement) {
            // Encoded value -> restore previous min
            minElement = 2 * minElement - top;
        }
    }

    // Get top element
    public int top() {
        int top = stack.peek();
        if (top >= minElement) {
            return top;
        } else {
            // Encoded value, real top = minElement
            return minElement;
        }
    }

    // Get minimum element
    public int getMin() {
        return minElement;
    }

    // Test
    public static void main(String[] args) {
        MinStackOptimized ms = new MinStackOptimized();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Min = " + ms.getMin()); // 2
        ms.pop();
        System.out.println("Min = " + ms.getMin()); // 3
        ms.pop();
        System.out.println("Top = " + ms.top());    // 3
        System.out.println("Min = " + ms.getMin()); // 3
    }
}
