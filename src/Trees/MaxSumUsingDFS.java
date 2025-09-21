package Trees;

import java.util.*;

public class MaxSumUsingDFS {
    Map<Integer, Integer> map = new HashMap<>();
    int maxLevel = 0; // to keep track of max depth

    void dfs(TreeNode root, int level) {
        if (root == null) return;

        map.put(level, map.getOrDefault(level, 0) + root.val);
        maxLevel = Math.max(maxLevel, level);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int resultant = 1;

        for (int level = 1; level <= maxLevel; level++) {
            int sum = map.get(level);

            if (sum > maxSum) { // strictly > ensures smallest level in tie
                maxSum = sum;
                resultant = level;
            }
        }

        return resultant;
    }
}
