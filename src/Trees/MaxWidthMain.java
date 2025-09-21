package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxWidthMain {

    // Pair class to hold node + index
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // ✅ Static variable to hold maxWidth
    static int maxWidth = 0;

    public static int maxWidth(TreeNode root) {
        if (root == null) return 0;

        // reset before each call (important if multiple test cases)
        maxWidth = 0;

        Deque<Pair> deque = new ArrayDeque<>();
        deque.offer(new Pair(root, 0));

        while (!deque.isEmpty()) {
            int l = deque.peekFirst().index;
            int r = deque.peekLast().index;

            maxWidth = Math.max(maxWidth, r - l + 1);

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Pair p = deque.poll();
                TreeNode node = p.node;
                int index = p.index;

                if (node.left != null) {
                    deque.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    deque.offer(new Pair(node.right, 2 * index + 2));
                }
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println("Maximum Width of Tree: " + maxWidth(root));
    }
}
