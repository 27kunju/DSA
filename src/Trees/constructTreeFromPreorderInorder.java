package Trees;

public class constructTreeFromPreorderInorder {


        int idx = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return solve(preorder, inorder, 0, inorder.length - 1);
        }

        private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {

            if (start > end) {
                return null;
            }

            int rootVal = preorder[idx];

            int i = start;
            while (i <= end && inorder[i] != rootVal) {
                i++;
            }

            idx++;

            TreeNode root = new TreeNode(rootVal);

            root.left = solve(preorder, inorder, start, i - 1);
            root.right = solve(preorder, inorder, i + 1, end);

            return root;
        }

}
