package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    protected final int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        val = x;
        left = null;
        right = null;

    }

    public static void inOrderTraversal(TreeNode root){
        if(root == null) return;

        inOrderTraversal(root.left);
        System.out.println(root.val + "->");
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root){
        if(root == null) return;

        System.out.println(root.val+ "->");

        //traversal the left node
        preOrderTraversal(root.left);

        //go to right node
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val+"->");
    }

    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()){
            TreeNode treeNode = treeNodeQueue.poll();
            System.out.println(treeNode.val+ "->");

            if(treeNode.left != null ){
                treeNodeQueue.add(treeNode.left);
            }

            if(treeNode.right != null){
                treeNodeQueue.add(treeNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(15);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        leftNode.left = new TreeNode(16);
        rightNode.left= new TreeNode(23);
        rightNode.right = new TreeNode(42);

        System.out.println(root.val);
        System.out.println(root.right.left.val);
    }
}
