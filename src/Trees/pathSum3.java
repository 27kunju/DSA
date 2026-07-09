package Trees;

public class pathSum3 {

    private int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return 0;

        helper(root, (long) targetSum);

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return ans;
    }

    private void helper(TreeNode root, long sum) {

        if (root == null)
            return;

        if (sum == root.val)
            ans++;

        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }
}
