package Trees;

import java.util.*;


public class Traversals {

    public void preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.val + " ");
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }

    public void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public void postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode peekNode = stack.peek();
            if (peekNode.right != null && lastVisited != peekNode.right) {
                curr = peekNode.right;
            } else {
                System.out.print(peekNode.val + " ");
                lastVisited = stack.pop();
            }
        }
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levels = -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            levels++; // finished one level
        }

        return levels;

    }


    //import question
    public static TreeNode findSuccessor(TreeNode root, int key){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
            if(currentNode.val == key){
                break;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Traversals t = new Traversals();

        System.out.print("Preorder: ");
        t.preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        t.inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        t.postorder(root);

        System.out.println("max height"+ " " + height(root));
    }
}
