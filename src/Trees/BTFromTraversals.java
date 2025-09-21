package Trees;

import java.util.*;


public class BTFromTraversals {

    static int idx = 0;

    public static TreeNode buildTree(int[] preOrder, int[] inOrder){
        return solve(preOrder, inOrder, 0, preOrder.length - 1);
    }

    public static TreeNode solve(int[] preOrder, int[] inOrder, int start, int end){
        if(start > end) return null; // ✅ base case

        TreeNode root = new TreeNode(preOrder[idx++]);

        int i = start;
        for(; i <= end; i++){
            if(root.val == inOrder[i]) break;
        }

        root.left = solve(preOrder, inOrder, start, i - 1);
        root.right = solve(preOrder, inOrder, i + 1, end);

        return root;
    }

    // Level-order traversal to print tree
    public static void printTree(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.print("Level-order traversal of the tree: ");
        printTree(root);
    }
}
