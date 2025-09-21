package Trees;

import Stream.Department;

import java.util.*;

public class ZigZagOrderMain {

    public static List<List<Integer>> zigZagOrder(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while( !queue.isEmpty()){
            int levelSize = queue.size();
            Deque<Integer> deque = new LinkedList<>();


            for(int i = 0; i<levelSize;i++){
                TreeNode currentNode = queue.poll();

                if(reverse){
                    deque.addFirst(currentNode.val);
                }else{
                    deque.addLast(currentNode.val);
                }

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            result.add(new ArrayList<>(deque));
            reverse = !reverse;
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> res = zigZagOrder(root);

        System.out.println(res);
    }
}
