package LinkedList;

public class palindromeList {
    public boolean isPalindrome(myNode head) {
        if (head == null || head.next == null) return true;

        // 1️⃣ Find middle using slow & fast pointers
        myNode slow = head;
        myNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2️⃣ Reverse second half
        myNode secondHalf = reverse(slow);
        myNode firstHalf = head;

        // 3️⃣ Compare both halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Helper method to reverse linked list
    private myNode reverse(myNode head) {
        myNode prev = null;
        while (head != null) {
            myNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
