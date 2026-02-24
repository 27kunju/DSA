package LinkedList;

public class removeGivenNodeMain {

    public myNode removeElements(myNode head, int val) {
        myNode dummy = new myNode(-1);
        dummy.next = head;

        myNode prev = dummy;

        while (head != null) {
            if (head.data == val) {
                // Skip the current node
                prev.next = head.next;
                head = head.next;
            } else {
                // Move both pointers forward
                prev = head;
                head = head.next;
            }
        }

        return dummy.next;
    }
}
