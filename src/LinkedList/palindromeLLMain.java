package LinkedList;

import java.util.Stack;

public class palindromeLLMain {


    //here we are using stack
    public boolean isPalindrome(myNode head) {
        if (head == null || head.next == null) return true;

        myNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();

        // Push first half values into stack
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If odd number of nodes, skip the middle node
        if (fast != null) {
            slow = slow.next;
        }

        // Compare second half with values popped from stack
        while (slow != null) {
            if (stack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public boolean palindrome2(myNode head){
        myNode slow = head;
        myNode fast = head;

        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //LL is odd, we need the slow pointer to point to secondhalf
        if(fast !=null){
            slow = slow.next;
        }

        slow = reverseLLMain.reverseLL(slow);

        fast = head;

        //keep comparing secondhalf with firsthalf
        while(slow != null){
            if(slow.data !=fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}
