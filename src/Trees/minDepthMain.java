package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class minDepthMain {

    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth =1;

        while( !queue.isEmpty()){
            int n = queue.size();

            for(int i = 0; i<n;i++){

                TreeNode currentNode = queue.poll();

                if(currentNode.left == null && currentNode.right == null){
                    return depth;
                }

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            depth++;


        }


        return -1;


    }

    public int minDepth2(TreeNode root) {

        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        int l = root.left != null? minDepth(root.left): Integer.MAX_VALUE;
        int r = root.right != null ?minDepth(root.right): Integer.MAX_VALUE;


        return 1+ Math.min(l,r);



    }
}
