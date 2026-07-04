package Trees;

public class pathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    private boolean pathSum(TreeNode root, int targetSum, int curr) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (curr + root.val) == targetSum;
        }

        boolean left = pathSum(root.left, targetSum, curr + root.val);
        boolean right = pathSum(root.right, targetSum, curr + root.val);

        return left || right;
    }
}
