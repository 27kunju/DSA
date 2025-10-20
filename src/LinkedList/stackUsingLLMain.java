package LinkedList;

public class stackUsingLLMain {
    myNode head = null;

    // Push element onto stack
    public void push(int x) {
        myNode node = new myNode(x);
        node.next = head;
        head = node;
    }

    // Pop top element from stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        int x = head.data;
        head = head.next;
        return x;
    }

    // Peek top element without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return head.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Test your custom stack
    public static void main(String[] args) {
        stackUsingLLMain st = new stackUsingLLMain();
        st.push(2);
        st.push(4);
        System.out.println(st.peek()); // 4
        System.out.println(st.pop());  // 4
        System.out.println(st.pop());  // 2
        System.out.println(st.isEmpty()); // true
    }
}
