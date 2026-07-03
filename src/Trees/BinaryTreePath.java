package Trees;

import java.util.*;

class TreeNode2 {

    int value;

    TreeNode2 getParent() {
        return null;
    }

    TreeNode2 getLeftChild() {
        return null;
    }

    TreeNode2 getRightChild() {
        return null;
    }
}

public class BinaryTreePath {

    public static List<TreeNode2> findPath(TreeNode2 node1, TreeNode2 node2) {

        // Store ancestors of node1
        Set<TreeNode2> ancestors = new HashSet<>();

        TreeNode2 curr = node1;
        while (curr != null) {
            ancestors.add(curr);
            curr = curr.getParent();
        }

        // Find LCA
        curr = node2;
        while (!ancestors.contains(curr)) {
            curr = curr.getParent();
        }

        TreeNode2 lca = curr;

        List<TreeNode2> path = new ArrayList<>();

        // node1 -> LCA
        curr = node1;
        while (curr != lca) {
            path.add(curr);
            curr = curr.getParent();
        }
        path.add(lca);

        // LCA -> node2
        Stack<TreeNode2> stack = new Stack<>();

        curr = node2;
        while (curr != lca) {
            stack.push(curr);
            curr = curr.getParent();
        }

        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }

        return path;
    }

    public static void printPath(List<TreeNode2> path) {
        for (TreeNode2 node : path) {
            System.out.print(node.value + " ");
        }
    }
}