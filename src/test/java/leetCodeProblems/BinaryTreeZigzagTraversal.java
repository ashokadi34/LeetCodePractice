package leetCodeProblems;

import java.util.*;

class TreeNode {
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

//BinaryTreeZigzagTraversal
public class BinaryTreeZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isLeftToRight = true;
        
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            if (!isLeftToRight) {
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            isLeftToRight = !isLeftToRight;
        }
        
        return result;
    }
}

// Local test class
class Main {
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        BinaryTreeZigzagTraversal sol = new BinaryTreeZigzagTraversal();
        System.out.println(sol.zigzagLevelOrder(root1));  // [[3], [20, 9], [15, 7]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println(sol.zigzagLevelOrder(root2));  // [[1]]

        // Example 3
        System.out.println(sol.zigzagLevelOrder(null));  // []
    }
}
