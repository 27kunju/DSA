package Trees;



public class FlattenBSTToDLL {

        private TreeNode prev = null; // last processed node
        private TreeNode head = null; // head of DLL

        // Convert BST to Doubly Linked List
        TreeNode flattenToDLL(TreeNode root) {
            inorder(root);
            return head;
        }

        private void inorder(TreeNode node) {
            if (node == null) return;

            // Left subtree
            inorder(node.left);

            // Process current node
            if (prev == null) {
                head = node; // first node becomes head
            } else {
                prev.right = node; // link prev → current
                node.left = prev;  // link current ← prev
            }
            prev = node; // move prev to current

            // Right subtree
            inorder(node.right);
        }

        // Utility to print DLL forward
        void printForward(TreeNode head) {
            TreeNode curr = head;
            while (curr != null) {
                System.out.print(curr.val + " ");
                if (curr.right == null) break;
                curr = curr.right;
            }
            System.out.println();
        }

        // Utility to print DLL backward
        void printBackward(TreeNode tail) {
            TreeNode curr = tail;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.left;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            FlattenBSTToDLL sol = new FlattenBSTToDLL();

            // Build a sample BST
        /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
        */
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right.left = new TreeNode(5);
            root.right.right = new TreeNode(7);

            // Flatten BST to doubly linked list
            TreeNode head = sol.flattenToDLL(root);

            // Print DLL forward
            System.out.println("Doubly Linked List (forward):");
            sol.printForward(head);

            // Find tail and print backward
            TreeNode tail = head;
            while (tail.right != null) {
                tail = tail.right;
            }
            System.out.println("Doubly Linked List (backward):");
            sol.printBackward(tail);
        }
    }

