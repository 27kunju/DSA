package Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element x
    public void push(int x) {
        mainStack.push(x);
        // If minStack is empty or x <= current min, push x
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            // Push the current min again to keep size in sync
            minStack.push(minStack.peek());
        }
    }

    // Pop element
    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    // Get top element
    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        throw new RuntimeException("Stack is empty");
    }

    // Get min element
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("Stack is empty");
    }

    // Test
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Current Min = " + ms.getMin()); // 2
        ms.pop();
        System.out.println("Current Min = " + ms.getMin()); // 3
        ms.pop();
        System.out.println("Top = " + ms.top());            // 3
        System.out.println("Current Min = " + ms.getMin()); // 3
    }
}
