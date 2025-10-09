package Trees;

public class MaxAncestorDiffBruteForce {

    static int maxDiff = 0;

    // Helper function to explore all descendants
    public static void findForAncestor(TreeNode node, int ancestorVal) {
        if (node == null) return;

        // Update max difference
        maxDiff = Math.max(maxDiff, Math.abs(node.val - ancestorVal));

        // Recurse for children
        findForAncestor(node.left, ancestorVal);
        findForAncestor(node.right, ancestorVal);
    }

    // For every node, call helper on its descendants
    public static void traverse(TreeNode root) {
        if (root == null) return;

        // Compare root value with all descendants
        findForAncestor(root, root.val);

        // Recurse to check other ancestors
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        traverse(root);

        System.out.println("Maximum difference = " + maxDiff);
    }
}
