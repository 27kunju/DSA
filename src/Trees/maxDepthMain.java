package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepthMain {

    public static int maxDepth(TreeNode root){

        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while( !queue.isEmpty()){

            for(int i = 0; i< queue.size();i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            depth++;
        }

        return depth;
    }

    public static int maxDepth2(TreeNode root){
        if(root == null)
            return 0;

        int l = maxDepth2(root.left);
        int r = maxDepth2(root.right);

        return Math.max(l,r)+1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }
}
