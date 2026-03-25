package Stack;

class MyStack<T> {

    // Inner Node class
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top; // top of stack
    private int size;

    // Push element to stack
    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
        size++;
    }

    // Pop element from stack
    public T pop() {
        if (top == null) throw new RuntimeException("Stack is empty");
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    // Peek element
    public T peek() {
        if (top == null) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get size of stack
    public int size() {
        return size;
    }
}