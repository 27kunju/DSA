package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class avgAtLevelMain {

    public List<Double> avgAtLevel(TreeNode root){
        List<Double> avg = new ArrayList<>();

        if(root == null){
            return avg;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            double sum = 0;
            for(int i = 0; i<levelSize;i++){
                TreeNode currentNode = queue.poll();

                sum += currentNode.val;

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            avg.add(sum/levelSize);


        }

        return avg;

    }
}
