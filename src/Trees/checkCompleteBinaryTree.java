package Trees;


public class checkCompleteBinaryTree {

    // Count total nodes in tree
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // DFS check if tree is complete
    public boolean dfs(TreeNode root, int i, int totalNodes) {
        if (root == null) {
            return true;
        }
        if (i > totalNodes) {   // node index should not exceed total
            return false;
        }
        return dfs(root.left, 2 * i, totalNodes) &&
                dfs(root.right, 2 * i + 1, totalNodes);
    }

    // Wrapper function
    public boolean isComplete(TreeNode root) {
        int totalNodes = countNodes(root);
        return dfs(root, 1, totalNodes); // start index from 1
    }

    // Main to test
    public static void main(String[] args) {
        checkCompleteBinaryTree checker = new checkCompleteBinaryTree();

        // Example: Complete Binary Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);

        System.out.println("Tree 1 is complete? " + checker.isComplete(root1)); // true

        // Example: Not a Complete Binary Tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(6); // Missing left child under 3

        System.out.println("Tree 2 is complete? " + checker.isComplete(root2)); // false
    }
}
