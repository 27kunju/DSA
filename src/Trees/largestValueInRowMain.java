package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class largestValueInRowMain {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;

            int n = queue.size();
            for(int i = 0;i<n;i++){
                TreeNode node = queue.poll();

                if(node.val > max){
                    max = node.val;
                }

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }

            }

            res.add(max);

        }

        return res;



    }

    // using dfs
    public static List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;

        // If this is the first node at this level
        if (res.size() == level) {
            res.add(node.val);
        } else {
            // Update max at this level
            res.set(level, Math.max(res.get(level), node.val));
        }

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}
