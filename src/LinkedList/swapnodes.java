package LinkedList;

public class swapnodes {
    public myNode swapPairs(myNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        myNode nextNode = head.next;              // Node B
        head.next = swapPairs(head.next.next);      // Swap the rest
        nextNode.next = head;                        // Swap current pair

        return nextNode;                             // New head of this pair
    }
}
