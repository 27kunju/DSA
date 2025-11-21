package LinkedList;

public class oddEven {
    public myNode oddEvenList(myNode head) {

        if (head == null)
            return head;

        myNode odd = head;
        myNode even = head.next;

        // Maintain the even head
        myNode evenHead = even;

        while (even != null && even.next != null) {

            // Change pointers for odd list
            odd.next = odd.next.next;
            odd = odd.next;

            // Change pointers for even list
            even.next = even.next.next;
            even = even.next;
        }

        // Assign even list at the end of odd list
        odd.next = evenHead;

        return head;
    }
}
