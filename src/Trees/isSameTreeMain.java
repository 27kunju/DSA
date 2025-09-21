package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class isSameTreeMain {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q == null) {
            return true;
        }

        if( p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


    //using BFS
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        if(p==null && q == null) {
            return true;
        }

        if( p == null || q == null){
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);

        while( !queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode currentNode1 = queue1.poll();
            TreeNode currentNode2 = queue2.poll();

            if(currentNode1.val != currentNode2.val){
                return false;

            }

            if(currentNode1.left != null && currentNode2.left != null){
                queue1.offer(currentNode1.left);
                queue2.offer(currentNode2.left);
            }else if(currentNode1.left != null || currentNode2.left !=null){
                return false;
            }

            if(currentNode1.right != null && currentNode2.right !=null){
                queue1.offer(currentNode1.right);
                queue2.offer(currentNode2.right);
            }else if(currentNode1.right != null || currentNode2.right != null){
                return false;
            }
        }

        return true;



    }


}
