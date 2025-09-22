package Trees;

import java.util.*;

public class AllNodesAtDistantKMain {
    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public static void inOrder(TreeNode root){
        if(root == null) return;

        if(root.left != null){
            parentMap.put(root.left, root);
        }
        if(root.right != null){
            parentMap.put(root.right, root);
        }

        inOrder(root.left);
        inOrder(root.right);
    }

    public static List<Integer> bfs(TreeNode target, int k, List<Integer> res){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while(!queue.isEmpty()){
            int n = queue.size();
            if(k == 0){
                break;
            }

            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();

                if(node.left != null && !visited.contains(node.left)){
                    queue.offer(node.left);
                    visited.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                if(parentMap.containsKey(node)){
                    TreeNode parent = parentMap.get(node);
                    if(!visited.contains(parent)){
                        queue.offer(parent);
                        visited.add(parent);
                    }
                }
            }
            k--;
        }

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        List<Integer> res = new ArrayList<>();
        inOrder(root);

        System.out.println(bfs(root.left, 2, res)); // should print [4,5,1] for K=2 from node 2
    }
}
