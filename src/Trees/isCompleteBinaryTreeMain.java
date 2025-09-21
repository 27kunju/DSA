package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleteBinaryTreeMain {

    public static boolean isCompleteBinaryTree(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean past = false;

        while( ! queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node == null){
                past = true;
            }else{
                if(past){
                    return false;
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(isCompleteBinaryTree(root));
    }
}
