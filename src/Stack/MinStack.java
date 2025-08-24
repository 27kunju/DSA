package Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    // Push element x
    public void push(int x) {
        mainStack.push(x);
        // If minStack is empty or x <= current min, push x
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Pop element
    public int pop() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        int ans = mainStack.pop();
        if (!minStack.isEmpty() && minStack.peek() == ans) {
            minStack.pop();
        }
        return ans;
    }

    // Get min element
    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    // Get top element
    public int top() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        return mainStack.peek();
    }

    // Main method to test
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(8);

        System.out.println("Current Min: " + stack.getMin()); // should print 2

        stack.pop(); // pops 8
        System.out.println("Current Min: " + stack.getMin()); // still 2

        stack.pop(); // pops 2
        System.out.println("Current Min: " + stack.getMin()); // should print 3

        stack.pop(); // pops 7
        System.out.println("Current Min: " + stack.getMin()); // should still print 3

        stack.pop(); // pops 3
        System.out.println("Current Min: " + stack.getMin()); // should print 5
    }
}
