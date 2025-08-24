package Stack;

import java.util.LinkedList;

public class StackLL {
    LinkedList<Integer> list = new LinkedList<>();

    public void push(int x) {
        list.addFirst(x);
    }

    public int pop() {
        return list.removeFirst();
    }

    public int top() {
        return list.getFirst();
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
