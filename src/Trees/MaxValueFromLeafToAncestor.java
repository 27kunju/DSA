package Trees;

public class MaxValueFromLeafToAncestor {


    public static int findMaxValue(TreeNode root, int minV, int maxV){

        if(root == null){
            return Math.abs(minV- maxV);
        }

        minV = Math.min(minV, root.val);
        maxV = Math.max(maxV, root.val);

        int l = findMaxValue(root.left, minV, maxV);
        int r = findMaxValue(root.right, minV,maxV);

        return Math.max(l,r);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(findMaxValue(root, root.val, root.val));
    }
}
