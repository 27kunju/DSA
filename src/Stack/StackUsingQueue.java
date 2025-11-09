package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        for(int i=0; i<q.size()-1; i++){
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    /*

    ✅ Summary Notes – Time Complexity (One Queue Stack)

push(x) is O(n) because after inserting the new element, we rotate all previous elements to the back to make x the front of the queue (stack top).

pop() is O(1) since the front of the queue always holds the top element.

top() is O(1) using peek() on the queue’s front.

empty() is O(1) as it simply checks if the queue is empty.

Overall space complexity is O(n) because the queue stores all stack elements.
    | Operation | Time Complexity |
| --------- | --------------- |
| push      | O(n)            |
| pop       | O(1)            |
| top       | O(1)            |
| empty     | O(1)            |

     */
}
