package leetCodeProblems;

import java.util.*;

public class LevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>();
                
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    currentLevel.add(node.val);
                    
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                
                result.add(currentLevel);
            }
            
            return result;
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        
        System.out.println(sol.levelOrder(root1));
        // Output: [[3],[9,20],[15,7]]
        
        // Example 2: [1]
        TreeNode root2 = new TreeNode(1);
        System.out.println(sol.levelOrder(root2));
        // Output: [[1]]
        
        // Example 3: []
        System.out.println(sol.levelOrder(null));
        // Output: []
    }
}
