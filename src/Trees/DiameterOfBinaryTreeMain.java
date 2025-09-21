package Trees;

public class DiameterOfBinaryTreeMain {

    static int diameter = 0;


    public static int dfs(TreeNode root){

        if(root == null){
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        diameter = Math.max(diameter, l+r);

        return 1+ Math.max(l,r);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        dfs(root);
        System.out.println(diameter);
    }
}
