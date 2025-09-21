package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetricMain {

    public static boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i =0; i<levelSize;i++){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                if(left == null && right == null){
                    continue;
                }


                if(left == null || right == null){
                    return false;
                }

                if(left.val != right.val){
                    return false;
                }

                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);


            }
        }


        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));

    }
}
