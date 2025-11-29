package LinkedList;

public class swapNodesOfK {
    public myNode swapNodes(myNode head, int k) {
        myNode dummy = new myNode(-1);
        dummy.next = head;

        myNode temp = dummy;

        // Move temp to k-th node from start
        while (k > 0) {
            temp = temp.next;
            k--;
        }

        myNode p1 = temp; // k-th node from start
        myNode p2 = head; // pointer to find k-th from end

        // Move temp to the end, move p2 along → p2 points to k-th from end
        while (temp != null && temp.next != null) {
            temp = temp.next;
            p2 = p2.next;
        }

        // Swap dataues
        int data = p1.data;
        p1.data = p2.data;
        p2.data = data;

        return dummy.next;
    }
}
