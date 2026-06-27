package LinkedList;

import java.util.*;

class ListNode{

    int val ;
    ListNode next;
}

public class rotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = findLength(head);

        k = k % n;

        if (k == 0) {
            return head;
        }

        // Reverse entire list
        head = reverse(head);

        // Find kth node
        ListNode current = head;

        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        ListNode part2 = current.next;
        current.next = null;

        // Reverse both parts
        ListNode part1 = reverse(head);
        part2 = reverse(part2);

        // Connect
        ListNode tail = part1;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = part2;

        return part1;
    }

    public int findLength(ListNode head) {

        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
