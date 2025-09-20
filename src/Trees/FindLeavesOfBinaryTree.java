package Trees;

import java.util.*;

public class FindLeavesOfBinaryTree {

    private static Map<Integer, List<Integer>> map = new HashMap<>();

    public static List<List<Integer>> findLeaves(TreeNode root) {
        int height = getHeight(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= height; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return -1; // base case
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int currHeight = 1 + Math.max(leftHeight, rightHeight);

        // instead of computeIfAbsent
        if (!map.containsKey(currHeight)) {
            map.put(currHeight, new ArrayList<>());
        }
        map.get(currHeight).add(node.val);

        return currHeight;
    }

    public static void main(String[] args) {
        // Build the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        List<List<Integer>> result = findLeaves(root);

        System.out.println(result); // Expected [[4, 5, 3], [2], [1]]
    }
}
