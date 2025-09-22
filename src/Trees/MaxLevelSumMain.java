package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumMain {

    public static int maxLevelSum(TreeNode root){
        if (root == null) return 0;

        int maxSum = Integer.MIN_VALUE;
        int resultant = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int sum = 0;
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            level++;
            if(sum > maxSum){
                maxSum = sum;
                resultant = level;
            }
        }

        return resultant;
    }
}
