package Stack;

import java.util.Stack;

public class QueueUsingStackWithoutVariable{
    private Stack<Integer> input;
    private Stack<Integer> output;

    public QueueUsingStackWithoutVariable() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
}
