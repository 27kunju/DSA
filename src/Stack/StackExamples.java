package Stack;

import java.util.*;

public class StackExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(16);

        stack.pop();

        //queue is interface, it works similar to linkedlist, so we can use implementation from linkedin
        Queue<Integer> queue = new LinkedList<>();

        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(1);
        System.out.println(queue.remove());

        //insert and delete from both sides in deque
        //arraydeque dynamically grows
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(89);
        deque.addLast(78);
       System.out.println( deque.removeFirst());





    }
}
