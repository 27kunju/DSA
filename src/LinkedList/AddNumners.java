package LinkedList;

public class AddNumners {

    public myNode addTwoNumbers1(myNode l1, myNode l2) {
        myNode dummy = new myNode(0); // dummy head
        myNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new myNode(sum % 10);

            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new myNode(carry);
        }

        return dummy.next;
    }

    private myNode reverse(myNode head) {
        myNode prev = null, curr = head;
        while (curr != null) {
            myNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public myNode addTwoNumbers(myNode l1, myNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        myNode dummy = new myNode(0);
        myNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = x + y + carry;

            curr.next = new myNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return reverse(dummy.next);
    }
}
