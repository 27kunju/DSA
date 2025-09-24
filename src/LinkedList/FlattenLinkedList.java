package LinkedList;

public class FlattenLinkedList {

    // Make Node static so it can be used in static methods
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    public static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        result.next = null; // ensure 'next' is not used
        return result;
    }

    // Flatten function
    public static Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        // Recur for list on right
        root.next = flatten(root.next);

        // Merge this list with the right list
        root = merge(root, root.next);

        return root;
    }

    // Print flattened list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    // Correct static main
    public static void main(String[] args) {
        // Build the sample list
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        /*
    The multi-level linked list looks like this:

    5 -> 10 -> 19 -> 28
    |     |     |     |
    7     20    22    35
    |           |     |
    8           50    40
    |                 |
    30                45

    After flattening, the list should be:
    5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 40 -> 45 -> 50
*/




        Node result = flatten(head);

        System.out.println("Flattened linked list:");
        printList(result);
    }
}
