package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSizeViewMain {

    public static List<Integer> rightSizeView(TreeNode root){

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int levelSize = queue.size();

            for(int i = 0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                if(i == levelSize-1){
                    result.add(currentNode.val);
                }

                if(currentNode.left != null){
                    queue.offer(currentNode.left);

                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(rightSizeView(root));

    }
}
